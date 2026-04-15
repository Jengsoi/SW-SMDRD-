package PokemonDTO;

public class PokemonDTO {
	
	public PokemonDTO() {
		
	}
	
	// 포켓몬DB
	
	public int HP;
    public int ATK;
    public int LOVE;
    public int EXP;
    public String PNAME;
	
    public PokemonDTO(int HP, int ATK, int LOVE, int EXP) {
    	// 선택지에 따른 능력치 불러오기용 생성자
    	super();
    	this.HP = HP;
    	this.ATK = ATK;
    	this.LOVE = LOVE;
    	this.EXP = EXP;
    }
    



	public int getHP() {
		return HP;
	}

	public void setHP(int hP) {
		HP = hP;
	}

	public int getATK() {
		return ATK;
	}

	public void setATK(int aTK) {
		ATK = aTK;
	}

	public int getLOVE() {
		return LOVE;
	}

	public void setLOVE(int lOVE) {
		LOVE = lOVE;
	}

	public int getEXP() {
		return EXP;
	}

	public void setEXP(int eXP) {
		EXP = eXP;
	}
	
	
    public String getPNAME() {
		return PNAME;
	}


	public String setPNAME(String pNAME) {
		return pNAME;
	}


	// 회원DB
    public String T_ID;
    public String T_PW;
    public int PCODE;

	public PokemonDTO(String T_ID, String T_PW) {
		// 로그인 확인용 생성자
		super();
		this.T_ID = T_ID;
		this.T_PW = T_PW;
		
	}

	
	
	

	public String getT_ID() {
		return T_ID;
	}


	public void setT_ID(String t_ID) {
		T_ID = t_ID;
	}


	public String getT_PW() {
		return T_PW;
	}


	public void setT_PW(String t_PW) {
		T_PW = t_PW;
	}


	public int getPCODE() {
		return PCODE;
	}


	public void setPCODE(int pCODE) {
		PCODE = pCODE;
	}
	
	
	public PokemonDTO(String T_ID, int HP, int ATK, int LOVE , int EXP , String PNAME ) {
		// 로그인 확인용 생성자
		super();
		this.T_ID = T_ID;
		this.HP = HP;
    	this.ATK = ATK;
    	this.LOVE = LOVE;
    	this.EXP = EXP;
    	this.PNAME = PNAME;
		
	}




	public PokemonDTO(String T_ID) {
		// 중복ID체크
		super();
		this.T_ID = T_ID;
	}
    
    
    
    

}
