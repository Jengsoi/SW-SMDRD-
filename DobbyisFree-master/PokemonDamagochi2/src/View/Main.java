package View;

import java.util.ArrayList;
import java.util.Scanner;

import PokemonController.ActCon;
import PokemonDAO.PokemonDAO;

public class Main {

	static PokemonController.ActCon pconAct = new PokemonController.ActCon();
	static PokemonController.AsciiArt pconArt = new PokemonController.AsciiArt();


	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		PokemonDAO pdao = new PokemonDAO();

		
		
		pconAct.main();

		



	

	}

}
