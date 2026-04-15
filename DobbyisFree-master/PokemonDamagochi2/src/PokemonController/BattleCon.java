package PokemonController;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import PokemonDAO.PokemonDAO;
import PokemonDTO.MuzDTO;
import PokemonDTO.PokemonDTO;

public class BattleCon {
	MusicCon MP = new MusicCon();
	// 고정값 뮤츠 개체 만들어야함
	// HP150 ATK 20~50중에 랜덤수

	// 배틀메소드 실행

	// 배틀기능
	// 1. 공격 2.상처약

	// 만약 뮤츠의 HP가 0 이하라면 ..
	// 물리쳤다 친구가 되었따 축하한다는 멘트 출력 및 --> 메인페이지 이동 or 게임종료 선택지 출력

	// 만약 Player (T_ID)의 HP가 0 이하라면 ...
	// 실패했다 대충 위로하는 멘트 출력 --> 메인페이지 이동 or 게임종료 선택지 출력

	ArrayList<PokemonDTO> t_pdto = new ArrayList<PokemonDTO>();
	PokemonDAO pdao = new PokemonDAO();
	PokemonDTO pdto = new PokemonDTO(0, 0, 0, 0);
	MuzDTO MD = new MuzDTO();
	static PokemonController.ActCon pconAct = new PokemonController.ActCon();
	static PokemonController.AsciiArt pconArt = new PokemonController.AsciiArt();
	static PokemonController.MusicCon pconMusic = new PokemonController.MusicCon();
	// 배틀기능

	Scanner sc = new Scanner(System.in);
	int input = 0;

	public void Battle(String id) {
		pconMusic.P(3);
		t_pdto = pdao.state(id);
		System.out.println("포켓몬 전투병기 [ 뮤츠 ]가 나타났다!");
		pconArt.Mewt();
		System.out.println("[ 뮤츠 ]의 HP : " + MD.getHp());
		System.out.println("가라! [ " + t_pdto.get(0).getPNAME() + " ] 널 믿어");
		while (true) {

			System.out.println("[ 뮤츠 ] 가 공격했다!");

			int MDAtk = MD.getAttack();
			t_pdto.get(0).setHP((t_pdto.get(0).getHP() - MDAtk));

			System.out.println(MDAtk + "의 데미지를 입었습니다.");
			System.out.println("[ " + t_pdto.get(0).getPNAME() + " ]" + " 은(는) " + "[ " + t_pdto.get(0).getT_ID()
					+ " ] 을(를) 슬프게 하지않기 위해 버텼다");

			

			MD.setHp(MD.getHp() - t_pdto.get(0).getATK());
			System.out.println("=========================================================");

			if (t_pdto.get(0).getHP() <= 0) {
				pconMusic.P(0);
				System.out.println("패배하였습니다... 채찍질이 부족한 것 같다");
				System.out.println("아무키나 입력하시면 메인으로 이동합니다.");
				String input1 = sc.next();
				pconAct.main();
				break;
			} else if (MD.getHp() <= 0) {
				pconMusic.P(1);
				System.out.println("승리하였습니다!");
				System.out.println("[ 뮤츠 ]와의 배틀에서 승리하였습니다!");
				if (t_pdto.get(0).getPNAME().equals("라이츄")) {
					pconArt.Raivic();
				} else if (t_pdto.get(0).getPNAME().equals("님피아")) {
					pconArt.Nimvic();
				} else if (t_pdto.get(0).getPNAME().equals("베이리프")) {
					pconArt.Bayvic();
				}
				System.out.println("[ 뮤츠 ]와 친구가 되었다!" + "[ " + t_pdto.get(0).getT_ID() + " ]" + " 은(는) 포켓몬마스터가 되었다");
				System.out.println();
				System.out.println("아무키나 입력하시면 메인으로 이동합니다.");
				String input1 = sc.next();
				// 크레딧
				pconMusic.P(7);
				pconAct.main();
				break;
			}
			if (t_pdto.get(0).getPNAME().equals("라이츄")) {

				pconArt.Raiatt();
				System.out.println(t_pdto.get(0).getPNAME() + "의 혼신의 힘을 다한 공격!");
			} else if (t_pdto.get(0).getPNAME().equals("님피아")) {
				pconArt.Nimatt();
				System.out.println(t_pdto.get(0).getPNAME() + "의 혼신의 힘을 다한 공격!");

			} else if (t_pdto.get(0).getPNAME().equals("베이리프")) {
				pconArt.Bayatt();
				System.out.println(t_pdto.get(0).getPNAME() + "의 혼신의 힘을 다한 공격!");

			}

		}

	}

}
