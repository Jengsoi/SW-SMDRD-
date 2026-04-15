import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Ex01_Main {

	public static void main(String[] args) {

		// 회원관리 프로그램
		// 실행공간
		// ID PW 이름 나이 --> 4개를 관리할 수 있는 데이터 타입(회원)을 만든다
		// 클래스 --> 나만의 새로운 데이터 타입을 만드는 것
		Scanner sc = new Scanner(System.in);
		MemberDAO dao = new MemberDAO();
		
		int row = 0;

		System.out.println("=========================SMHRD 회원관리 프로그램==========================");
		while (true) {
			System.out.print("[1]회원가입 [2]로그인 [3]전체회원목록 [4]회원정보수정 [5]회원탈퇴 [6]검색 >> ");
			int input = sc.nextInt();

			if (input == 1) {
				// 회원 가입
				// 사용자 입출력 구간
				System.out.print("ID 입력 : ");
				String id = sc.next();
			
				System.out.print("PW 입력 : ");
				String pw = sc.next();

				System.out.print("이름 입력 : ");
				String name = sc.next();
				System.out.print("나이 입력 : ");
				int age = sc.nextInt();
				
				row = dao.join(id, pw, name, age);
				if (row > 0) {
					System.out.println("회원가입 성공!!");
				} else {
					System.out.println("회원가입 실패");
				}
				
				
			} else if (input == 2) {
				// 로그인
				// 1. 사용자로부터 아이디와 비밀번호를 입력 받기
				System.out.print("ID 입력 : ");
				String id = sc.next();
				System.out.print("PW 입력 : ");
				String pw = sc.next();
				MemberDTO dto = dao.login(id, pw);
				if(dto != null) {
					System.out.println("로그인 성공!!");
				}else {
					System.out.println("로그인 실패");
				}
				
				
				
			} else if (input == 3) {
				// 전체회원목록
				System.out.println("======================================================================");
				System.out.printf("%8s\t%8s\t%8s\t%8s\n", "ID","PW","NAME","AGE");
				System.out.println("======================================================================");
				//MemberDTO mdto = dao.selectAllMember();
				ArrayList<MemberDTO> dtoList = dao.selectAllMember();
				for(int i = 0 ; i < dtoList.size(); i++) {
					System.out.printf("%8s\t%8s\t%8s\t%8s\n",dtoList.get(i).getId(),dtoList.get(i).getPw(),dtoList.get(i).getName(),dtoList.get(i).getAge());
				
				}
				System.out.println("======================================================================");
				

			} else if (input == 4) {
				// 회원정보수정
				// 1. 사용자로부터 아이디를 입력받아서 비밀번호를 수정
				System.out.print("ID 입력 : ");
				String id = sc.next();
				System.out.print("변경할 PW 입력 : ");
				String pw = sc.next();
				row = dao.updateMember(id,pw);
				if(row > 0) {
					System.out.println("비밀번호 변경 성공!!");
				}else {
					System.out.println("비밀번호 변경 실패");
				}
				
				
			} else if (input == 5) {
				// 회원탈퇴
				// id 입력 받아서 해당 id 삭제
				System.out.print("ID를 입력 하세요 : ");
				String id = sc.next();
				row = dao.deleteMember(id);
				if(row > 0) {
					System.out.println("회원탈퇴 성공!!");
				}else {
					System.out.println("회원탈퇴 실패");
				}

			} else if (input == 6) {
				// 검색 -- id 입력받아서 해당 아이디의 모든 정보를 출력
				// sql = "select * from member_info where id = ?"
				System.out.print("검색할 ID 입력 : ");
				String id = sc.next();
				MemberDTO mdto = dao.selectOne(id);
				System.out.println();
				System.out.println("======================================================================");
				System.out.printf("%8s\t%8s\t%8s\t%8s\n", "ID","PW","NAME","AGE");
				System.out.println("======================================================================");
				System.out.printf("%8s\t%8s\t%8s\t%8s\n",mdto.getId(),mdto.getPw(),mdto.getName(),mdto.getAge());
				System.out.println();

			} else {
				// 프로그램 종료
				System.out.println("프로그램을 종료합니다.");
				break;
			}

		}

	}
}
