package View;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// 출력문 입력 부탁드립니다.
		System.out.println("포켓몬마스터가 되기 위해 모험을 떠난 '너!'와 친구들, 긴 여정을 마치고 환상의 포켓몬과의 최종결전을 앞두고 있다.");

		System.out.println("결전에 앞서 혹독하고 처절한 트레이닝을 계획하는데...");

		// 오박사 등장
		System.out.println("그동안 고생많았다 이제 근본중에 근본인 그 녀석만 남았구나! 그간 함께했던 수많은 에이스포켓몬중에서 3마리를 엄선했단다.");

		System.out.println("아무리 그래도 한놈잡는데 다구리치는건 추잡하지 않니? 마지막으로 너와 함께할 포켓몬을 딱 1마리만 골라보렴");

		// 회원가입 및 포켓몬 선택
		Scanner sc = new Scanner(System.in);
		System.out.print("ID 입력 : ");
		String ID = sc.next();
		System.out.print("PW 입력 : ");
		String PW = sc.next();

		System.out.print("함께할 Pokemon 선택 : ");
		String Pokemon = sc.next();

		// 로그인
		System.out.print("ID 입력 : ");
		ID = sc.next();
		System.out.print("PW 입력 : ");
		PW = sc.next();

		// 키우기
		System.out.println("1.행동 선택   2.메인페이지");
		int start = sc.nextInt();

		System.out.println("<< 1.채찍질하기 2.놀아주기 3.잠자기 >> ");
		int training = sc.nextInt();

		System.out.println("---는 기분 좋은듯하다^^ 공격력이 올랐다!");
		System.out.println("경험치가 올랐다.");

		System.out.println("하하하하하하하~호호호호호호~흐헤흐헤흐히흐히히히히~ 친밀도가 올랐다!");
		System.out.println("경험치가 올랐다.");

		System.out.println("우리 ---는 자는 모습이 제일 귀엽당>< HP가 회복되었다!");
		System.out.println("경험치가 올랐다.");

		System.out.println("오잉?! ---의 상태가?");
		System.out.println("---는 ---로 진화했다!");

		// 최종배틀
		System.out.println("포켓몬 전투병기 뮤츠가 나타났다!");

		System.out.println("뮤츠와의 배틀에서 승리하였습니다!");

		System.out.println("뮤츠와 친구가 되었다! ID는 포켓몬마스터가 되었다");

		System.out.println("어머! ---는 싸우는 사이 뮤츠와 정분이 났다! ♡♡♡");

		// 패배
		System.out.println("패배하였습니다... 채찍질이 부족한 것 같다"); // 돌아가기

	}

}
