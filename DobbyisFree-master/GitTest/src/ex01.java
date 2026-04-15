import java.util.Scanner;

public class ex01 {

	public static void main(String[] args) {

		System.out.println("팀장 첫번째 커밋!");
		System.out.println("팀원1 두번째 커밋");
		System.out.println("팀원2 3번째 커밋?");
		System.out.println("팀원3 4번째 커밋~");
		System.out.println("집가고싶다");
		

		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		
		if(num % 2 == 0) {
			System.out.println("짝수입니다");
			
		}
		if(num % 2 != 0) {
			System.out.println("홀수입니다");
		}
		
		
		
		
	}

}
