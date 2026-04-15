package PokemonDTO;

public class TrainerDTO {

	
	private String  t_id;
	private String t_pw;
	
	public TrainerDTO(String t_id, String t_pw) {
		super();
		this.t_id = t_id;
		this.t_pw = t_pw;
	}
	public String getT_id() {
		return t_id;
	}
	public void setT_id(String t_id) {
		this.t_id = t_id;
	}
	public String getT_pw() {
		return t_pw;
	}
	public void setT_pw(String t_pw) {
		this.t_pw = t_pw;
	}
	
	
	
}
