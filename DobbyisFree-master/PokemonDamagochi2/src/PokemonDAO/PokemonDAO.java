package PokemonDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import PokemonController.ActCon;
import PokemonDTO.PokemonDTO;
import PokemonDTO.TrainerDTO;

public class PokemonDAO {
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;

	PokemonDTO pdto = new PokemonDTO(100, 0, 0, 0);

	static PokemonController.ActCon pcon = new PokemonController.ActCon();

	// 문열기
	public void getConn() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@172.30.1.40:1521:xe";
			String db_id = "POKEDB";
			String db_pw = "132456";
			conn = DriverManager.getConnection(url, db_id, db_pw);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void naming(String id , String name) {

		getConn();
		pdto = null;
		String sql = "UPDATE 포켓몬 SET PNAME = ? WHERE T_ID = ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);
			psmt.setString(2, id);
			psmt.executeUpdate();
			

		}

		catch (SQLException e) {

			e.printStackTrace();
		} finally {
			getClose();
		}

	}
	// UPDATE 행동선택때마다 감소하거나 증가하는 능력치 수정해주는 메소드

	// 채찍질 hp - 30 / atk + 5 / exp +2
	public void Whip(String id) {

		getConn();
		pdto = null;
		String sql = "UPDATE 포켓몬 SET HP = HP-30, ATK = ATK +5, EXP = EXP+2 WHERE T_ID = ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.executeUpdate();

		}

		catch (SQLException e) {

			e.printStackTrace();
		} finally {
			getClose();
		}

	}

	// 놀아주기 hp - 30 / love +5 / exp +2
	public void Play(String id) {

		getConn();
		pdto = null;
		String sql = "UPDATE 포켓몬 SET HP = HP-30, LOVE = LOVE +5, EXP = EXP+2 WHERE T_ID = ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.executeUpdate();

		}

		catch (SQLException e) {

			e.printStackTrace();
		} finally {
			getClose();
		}

	}

	// 잠자기 hp100 / exp +2
	public void Sleep(String id) {

		getConn();
		pdto = null;
		String sql = "UPDATE 포켓몬 SET HP = 100, EXP = EXP+2 WHERE T_ID = ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.executeUpdate();

		}

		catch (SQLException e) {

			e.printStackTrace();
		} finally {
			getClose();
		}

	}

	// 포켓몬 상태 메소드

	public ArrayList<PokemonDTO> state(String T_ID) {
		getConn();

		String sql = "SELECT T_ID , HP , ATK , LOVE, EXP ,PNAME FROM 포켓몬 WHERE T_ID = ? ";
		PokemonDTO t_pdto = null;
		ArrayList<PokemonDTO> t_pdtoList = new ArrayList<>();

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, T_ID);

			rs = psmt.executeQuery();

			if (rs.next()) {
				String T_id = rs.getString(1);
				int hp = rs.getInt(2);
				int atk = rs.getInt(3);
				int love = rs.getInt(4);
				int exp = rs.getInt(5);
				String pname = rs.getString(6);

				t_pdto = new PokemonDTO(T_id, hp, atk, love, exp, pname);
				t_pdtoList.add(t_pdto);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			getClose();
		}
		return t_pdtoList;

	}

	// 로그인 정보 체크하는 메소드 (select)
	// 포켓몬 상태창에 불러올 수 있다면 메소드 중복해서 활용하자

	// 회원가입 할때 ID 중복체크 진짜 도저히모르겠음
	public int DupCheck(String T_ID) {
		getConn();

		String sql = "SELECT T_ID FROM 트레이너 WHERE T_ID = ?";
		int result = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, T_ID);
			rs = psmt.executeQuery();
			while (rs.next()) {
				result = 1;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			getClose();
		}
		return result;

	}

	public TrainerDTO login(String T_ID, String T_PW) {
		getConn();

		String sql = "SELECT T_ID , T_PW FROM 트레이너 WHERE T_ID = ? AND T_PW = ?";
		TrainerDTO t_pdto = null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, T_ID);
			psmt.setString(2, T_PW);

			rs = psmt.executeQuery();

			if (rs.next()) {
				String T_id = rs.getString(1);
				String T_pw = rs.getString(2);

				t_pdto = new TrainerDTO(T_id, T_pw);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			getClose();
		}
		return t_pdto;

	}

	// 회원가입 메소드

	public void insertTrainer(String T_ID, String T_PW, int PCODE) {
		getConn();

		String sql = "INSERT INTO 트레이너 (T_ID, T_PW, PCODE) VALUES (?, ?, ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, T_ID);
			psmt.setString(2, T_PW);
			psmt.setInt(3, PCODE);
			psmt.executeUpdate();

			String sql_P = "INSERT INTO 포켓몬 (T_ID ,PCODE, HP, ATK, LOVE, EXP, PNAME) VALUES ( ?, ?,?,?,?,?,?)";
			psmt = conn.prepareStatement(sql_P);
			psmt.setString(1, T_ID);
			psmt.setInt(2, PCODE);
			psmt.setInt(3, pdto.getHP()); // 초기값: 100
			psmt.setInt(4, pdto.getATK()); // 초기값: 0
			psmt.setInt(5, pdto.getLOVE()); // 초기값: 0
			psmt.setInt(6, pdto.getEXP()); // 초기값: 0
			if (PCODE == 1) {
				psmt.setString(7, "피카츄");

			} else if (PCODE == 2) {
				psmt.setString(7, "이브이");

			} else if (PCODE == 3) {
				psmt.setString(7, "치코리타");

			}

			psmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("중복된 닉네임 입니다. 회원가입을 다시 진행해주세요..");
			pcon.main();
			e.printStackTrace();
			
		} finally {
			getClose();

		}

	}

	// 문닫기
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

}