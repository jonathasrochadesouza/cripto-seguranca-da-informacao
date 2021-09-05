package cripto;

import java.util.Arrays;
import java.util.Iterator;
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
//	    System.out.println("Entre com a mensagem que deseja criptografar: ");
//	    Scanner myObj = new Scanner(System.in);
//	    String userName = myObj.nextLine();
//	    System.out.println("Sua mensagem criptografada: " + convertInNumber(transformText(userName)));
	    
	    String[] numerosTeste = {"01", "02"};
		
	    System.out.println(Arrays.toString(calcMaxValueInKeyArray(numerosTeste)));
	}
	
	private static String[] numChaveMax = new String[5];

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
	private static String[] numeros = {"01", "02", "03", "04", "05", "06",
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
				stringToNumberCripto = stringToNumberCripto + numeros[i];
				
				i = -1;
				iN++;
			}
		}
		
		return stringToNumberCripto;
	}
	
	private static String[] numberToArray(String numberConverted) {
		return numberConverted.split("(?<=\\G.{2})"); // regex
	}
	
	private static int[] calcMaxValueInKeyArray(String[] arrayTextInNumber) {

		int[] numChaveMaxArray = new int[5];
		
		int iKey = 0;
		
		for (int i = 0; i < arrayTextInNumber.length /*&& iKey <= numChaveMax.length*/; i++) {

			if (arrayTextInNumber[i].compareTo(numeros[i]) == 0) {
				
				if (i > numChaveMaxArray[iKey]) {
					numChaveMaxArray[iKey] = i;

					i = -1;
				}
				
				if (iKey < numChaveMaxArray.length) {
					iKey++;
				} else if (iKey >= numChaveMaxArray.length) {
					iKey = 0;
				}
			}
		}

		return numChaveMaxArray;
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
