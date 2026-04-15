import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDAO {
	// 공통필드
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	// 데이터에 접근하는 것을 도와주는 객체
	// DB랑 연결해서 INSERT , DELETE , SELECT , UPDATE 하는 코드들의 모음
	// 메소드 형태로 코드 작성

	// 기본!!!!문열고(동적연결) 통로 열고 sql문 담아주고 executeUpdate 해주고 문닫아주기
	// select 문은 값만 받아오면 돼서 ResultSet / executeQuery 로 원하는 행(컬럼) 데이터 가져오기

	// DB 연결 메소드

	public void getConn() {
		try {
//		// 1. 드라이버 동적 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
//		// 2. DB 연결 통로 열어주기 !
//		// --> URL, USER, PASSWORD
//
			String db_id = "service";
			String db_pw = "12345";
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
//
//		// 연결 DriverManager
//
			conn = DriverManager.getConnection(url, db_id, db_pw);
			// Connection 이란?
			// : 데이터베이스에 접속하기 위한 모든 메소드를 가진 인터페이스
			// ---> 데이터베이스와 하는 모든 통신은 conn을 통해서만 이루어진다.

		} catch (Exception e) {

			// 예외상황이 왜 발생했고, 어디서 문제가 생겼는지 출력!
			// 모든 예외 클래스는 Exception을 상속받는다.
			// 예를들어 Exception e = new ClassNotFoundException();
			// --> 업캐스팅이 일어나는 개념
			e.printStackTrace();
		}
	}
// ----------------------------------------getConn 메소드 끝
	// DB 연결 종료 메소드

	public void getClose() {

		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();

			if (conn != null)
				conn.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
//-----------------------------------------------getClose 메소드 끝

	// 회원가입 메소드
	public int join(String id, String pw, String name, int age) {
		int row = 0;

		try {
			getConn();

			// 3. SQL 쿼리문 준비
			// 회원가입 >> MEMBER_INFO
			String sql = "INSERT INTO MEMBER_INFO VALUES (?,?,?,?)";

			// 4. SQL문 전송(실행)
			psmt = conn.prepareStatement(sql);
			// --> 전송하기 전에 SQL문에 담아서 전송할 수 있는 형식으로 변경

			// ? 채우는 작업
			psmt.setString(1, id);
			psmt.setString(2, pw);
			psmt.setString(3, name);
			psmt.setInt(4, age);

			row = psmt.executeUpdate(); // --> 쿼리문 실행
			// executeUpdate() : insert, delete, update 사용 !

			// 5. 결과를 이용한 작업처리 출력
			// 사용자에게 어떤 모습을 보여줄건지 정의
		} catch (Exception e) {

			// 예외상황이 왜 발생했고, 어디서 문제가 생겼는지 출력!
			// 모든 예외 클래스는 Exception을 상속받는다.
			// 예를들어 Exception e = new ClassNotFoundException();
			// --> 업캐스팅이 일어나는 개념
			e.printStackTrace();
		} finally {
			// 위에서 예외상황이 발생하더라도 반드시 한번은 들어오는 구간
			// 6. DB 연결 종료 ---> 자원 반납
			// *** 자원을 반납할 때는 항상 열어준 순서의 반대로 반납한다.

			getClose();
		}

		return row;

	}

//------------------------------------------------------ 회원가입 메소드 끝
	// 로그인 메소드
	public MemberDTO login(String id, String pw) {

		getConn();
		String sql_login = "SELECT * FROM MEMBER_INFO WHERE ID = ?  AND PW = ?";
		MemberDTO mdto = null;

		try {
			psmt = conn.prepareStatement(sql_login);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			rs = psmt.executeQuery();

			if (rs.next()) {
				// 중복이 없다는 가정하에(보통 회원가입 id는 중복없으니까) if문도 사용 가능
				String s_id = rs.getString(1);
				String s_pw = rs.getString(2);
				String s_name = rs.getString(3);
				int s_age = rs.getInt(4);

				mdto = new MemberDTO(s_id, s_pw, s_name, s_age);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			
			getClose();

		}
		return mdto;

	}

//-----------------------------------------------------------로그인 메소드 끝

	// 회원 비밀번호 수정 메소드
	public int updateMember(String id, String pw) {
		int row = 0;
		String sql = "UPDATE MEMBER_INFO SET PW = ? WHERE ID = ?";
		getConn();
		try {
			// 통로 열었습니다.
			psmt = conn.prepareStatement(sql);
			// ? 채워주기
			psmt.setString(1, pw);
			psmt.setString(2, id);
			// 통과시키기
			row = psmt.executeUpdate();

			// 문닫아주기

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			getClose();
		}
		return row;

	}
//----------------------------------------------------------비밀번호 수정 메소드 끝

	public int deleteMember(String id) {
		int row = 0;
		String sql = "DELETE MEMBER_INFO WHERE ID = ?";
		getConn();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			row = psmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			getClose();

		}
		return row;

	}
//-------------------------------------------------------------회원탈퇴 메소드 끝

	public ArrayList<MemberDTO> selectAllMember() {
		String sql = "SELECT * FROM MEMBER_INFO";
		MemberDTO mdto = null;
		ArrayList<MemberDTO> dtoList = new ArrayList<>();

		getConn();
		try {
			psmt = conn.prepareStatement(sql);
			// select 문 실행하는 메소드 = > executeQuery
			rs = psmt.executeQuery();
			// ResultSet --> 커서 객체 데이터의 유무를 한줄씩 확인
			// 한줄 씩 확인 메소드 next();

			while (rs.next()) {
				// rs.next(); ---> 데이터가 있으면 true , 없으면 false
				// 데이터 가져오기
				// ResultSet에 있습니다
				String id = rs.getString(1);
				// -->getString() 매개변수는 index 가능, 컬럼명도 가능
				// index의 기준은 자바에서 select 해온 내용이 기준
				String pw = rs.getString(2);
				String name = rs.getString(3);
				int age = rs.getInt(4);
				mdto = new MemberDTO(id, pw, name, age);
				dtoList.add(mdto);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

			getClose();

		}
		return dtoList;

	}

//-----------------------------------------------------------전체회원목록 메소드 끝

	public MemberDTO selectOne(String id) {
		getConn();
		String sql = "SELECT * FROM MEMBER_INFO WHERE ID = ?";
		
		MemberDTO mdto = null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			
			
			while(rs.next()) {
				String id_1 = rs.getString(1);
				String pw_1 = rs.getString(2);
				String name_1 = rs.getString(3);
				int age_1 = rs.getInt(4);
				
				mdto = new MemberDTO(id_1,pw_1,name_1,age_1);
				
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			getClose();
		}return mdto;

	}

}
