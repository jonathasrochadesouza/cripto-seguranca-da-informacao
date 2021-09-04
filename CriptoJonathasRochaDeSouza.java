package cripto_5bytes;

import java.util.Scanner;

/**
 * 
 * @author Jonathas Rocha de Souza
 */
public class CriptoJonathasRochaDeSouza {

	/*
	 * Obs:
	 * ToLowerCase()
	 * ToInteger()
	 * Separate a cada 2 digitos e verificar o tamanho
	 */
	
//	String[] criptoIn = criptoIn[]; --> ArrayList --> ToArray()
//	CompareTo
//	indice das letras somado a um
//	forIt :
//  váriar a quantidade do array de acordo de acordo o valor máximo, para não ultrapassar de 0. Caso a letra seja z o valor dela é 26 a chave que soma com ela deverá ser 0, para que seja possível realizar a soma sem erros
	
	public static void main(String[] args) {
	    System.out.println("Entre com a mensagem que deseja criptografar: ");
	    Scanner myObj = new Scanner(System.in);
	    String userName = myObj.nextLine();
	    System.out.println("Username is: " + convertInNumber(transformText(userName)));
	    
	    
	    
	}

	/**
	 * 
	 */
	private static String[] letras = {"a", "b", "c", "d", "e", "f",
									  "g", "h", "i", "j", "k", "l",
									  "m", "n", "o", "p", "q", "r",
									  "s", "t", "u", "v", "w", "x",
									  "y", "z", " "};
	
	/**
	 * 
	 */
	private static String[] numbers = {"01", "02", "03", "04", "05", "06",
									   "07", "08", "09", "10", "11", "12", 
									   "13", "14", "15", "16", "17", "18", 
									   "19", "20", "21", "22", "23", "24", 
									   "25", "26", "00"};
	
	private static String[] transformText(String text) {
		String textLower = text.toLowerCase();
		
		String[] resultado = textLower.split("");
		
		return resultado;
	}
	
	private static String convertInNumber(String[] textArray) {
		String stringToNumberCripto = "";
		
		int iN = 0;
		for (int i = 0; i <= letras.length && iN <= (textArray.length - 1); i++) {
			if (textArray[iN].compareTo(letras[i]) == 0) { //
				stringToNumberCripto = stringToNumberCripto + numbers[i];
				
				i = -1;
				iN++;
			}
		}
		
		return stringToNumberCripto;
	}
	
	/**
	 * Criptografa
	 */
	private static void criptografia() {

	}
	
	/**
	 * Descriptografa
	 */
	private static void descriptografia() {
		// TODO Auto-generated method stub

	}
	
//	Scanner myObj = new Scanner(System.in);  // Create a Scanner object
//    System.out.println("Enter username");
//
//    String userName = myObj.nextLine();  // Read user input
//    System.out.println("Username is: " + userName);  // Output user input
	
}
