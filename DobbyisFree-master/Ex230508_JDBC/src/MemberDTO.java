
public class MemberDTO {
	
	// DTO : Data Transfer Object -->> 데이터를 이동할 수 있게 하는 나만의 자료형
	// 1. Table 마다 한개씩 가진다
	// 테이블의 컬럼 -> 필드값
	
	// 1. 필드값
	private String id;
	private String pw;
	private String name;
	private int age;
	
	
	
	
	
	
	
	// 2. 생성자 메소드
	
	public MemberDTO(String id, String pw, String name, int age) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.age = age;
	}







	public String getId() {
		return id;
	}







	public void setId(String id) {
		this.id = id;
	}







	public String getPw() {
		return pw;
	}







	public void setPw(String pw) {
		this.pw = pw;
	}







	public String getName() {
		return name;
	}







	public void setName(String name) {
		this.name = name;
	}







	public int getAge() {
		return age;
	}







	public void setAge(int age) {
		this.age = age;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
