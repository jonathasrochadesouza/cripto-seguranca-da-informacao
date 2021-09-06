package cripto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

/**
 * 
 * @author Jonathas Rocha de Souza
 */
public class JonathasCripto {

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
	    
//	    String[] numerosTeste = {"00", "00", "26", "00", "00", "01", "01", "01", "00", "24"};
//	    System.out.println(Arrays.toString(newMethodTestExperiment(numerosTeste)));
		
		System.out.println(Arrays.toString(descriptografia("2020202020202020", "0102030405")));
		
//		System.out.println("Caso algo tenha dado errado, por favor, certifique a chave e a mensagem criptografada!");
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
	
	/**
	 * 
	 * @param arrayTextInNumber
	 * @return
	 */
	private static int[] newMethodTestExperiment(String[] arrayTextInNumber) {
		
		int[] numChaveMaxArray = new int[5];
		int[] max = {26, 26, 26, 26, 26};
		
		int key = 0;
		int countAdd = 0;
		boolean liberado = false;
		
		for (int i = 0; liberado != true; i++) {
			
			if (i >= arrayTextInNumber.length && key >= 5 || key >= 5 && countAdd >= arrayTextInNumber.length) {
				liberado = true;
			}
			
			if (key < arrayTextInNumber.length && liberado != true) {
				if (countAdd < arrayTextInNumber.length ) {
					if (arrayTextInNumber[countAdd] == "00") {
						numChaveMaxArray[key] = 0;
						countAdd++;
						i = -1;
						
						if (key >= 4 && countAdd < arrayTextInNumber.length) {
							key = 0;
						} else {
							key++;
						}
					} else if (arrayTextInNumber[countAdd].compareTo(numeros[i]) == 0) {
						
						if (i+1 > numChaveMaxArray[key]) {
							numChaveMaxArray[key] = i+ 1;
						}

						countAdd++;
						i = -1;
						
						if (key >= 4 && countAdd < arrayTextInNumber.length) {
							key = 0;
						} else {
							key++;
						}
					
					}
				} else if (arrayTextInNumber[key] == "00") {
					numChaveMaxArray[key] = 0;
					countAdd++;
					i = -1;
					
					if (key >= 4 && countAdd < arrayTextInNumber.length) {
						key = 0;
					} else {
						key++;
					}
				} else if (arrayTextInNumber[key].compareTo(numeros[i]) == 0) {
					
					if (i+1 > numChaveMaxArray[key]) {
						numChaveMaxArray[key] = i+ 1;
					}

					countAdd++;
					i = -1;
					
//						numChaveMaxArray[key] = i+ 1;
//						i = -1;

//					if (key < 5 && countAdd <= arrayTextInNumber.length) {
//						key++;
//					} else {
//						key = 0;
//					}
					
					if (key >= 4 && countAdd < arrayTextInNumber.length) {
						key = 0;
					} else {
						key++;
					}
				
				}
				
				
			}
			
			if (key < 4 && i >= 26) {
				numChaveMaxArray[key] = 0;
				i = -1;
			}
			
		}
		
		for (int i = 0; i < 5; i++) {
			numChaveMaxArray[i] = max[i] - numChaveMaxArray[i];
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
	private static String[] descriptografia(String msg, String key) {
		String[] msgArray = msg.split("(?<=\\G.{2})");
		String[] keyArray = key.split("(?<=\\G.{2})");
		
		
		int[] msgConvertedToNumberArray = new int[msgArray.length];
		int[] keyConvertedToNumberArray = new int[5];
		
		int[] msgCriptCompl = new int[msgArray.length];
		String[] msgEnd = new String[msgArray.length];
		
		int iN = 0;
		for (int i = 0; iN <= 4; i++) {
			if (iN < keyArray.length) {
				if (keyArray[iN].compareTo(numeros[i]) == 0) {
					keyConvertedToNumberArray[iN] = i;
					iN++;
					i = -1;
				}
			} else if (i > numeros.length) {
				keyConvertedToNumberArray[iN] = 0;
				iN++;
				i = -1;
			}
		}
		
		int iN2 = 0;
		for (int i = 0; iN2 < msgArray.length; i++) {
			if (msgArray[iN2].compareTo(numeros[i]) == 0) {
				msgConvertedToNumberArray[iN2] = i;
				iN2++;
				i = -1;
			}
		}
		
		int iN3 = 0;
		for (int i = 0; i < msgConvertedToNumberArray.length; i++) {
			msgCriptCompl[i] = msgConvertedToNumberArray[i] - keyConvertedToNumberArray[iN3];
			if (iN3 < 4) {
				iN3++;
			} else {
				iN3 = 0;
			}
		}
		
		int iN4= 0;
		for (int i = 0; iN4 < msgCriptCompl.length; i++) {
			if (msgCriptCompl[iN4] == i) {
				msgEnd[iN4] = letras[i];
				iN4++;
				i = -1;
			}
		}

//		if (keyConvertedToNumberArray.length > 4 ) {
//			return "A chave parece estar incorreta!";
//		}
		
//		boolean liberado = false;
//		
//		for (int i = 0; liberado != true; i++) {
//			
//		}
		
		return msgEnd;
	}
	
//	Scanner myObj = new Scanner(System.in);  // Create a Scanner object
//    System.out.println("Enter username");
//
//    String userName = myObj.nextLine();  // Read user input
//    System.out.println("Username is: " + userName);  // Output user input
	
}

