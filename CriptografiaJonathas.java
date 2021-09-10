package cripto;

import java.util.Random;
import java.util.Scanner;

/**
 * Implementação de criptografia e descriptografia de mensagem.
 * 
 * Trabalho desenvolvido para a matéria de segurança da informação, na faculdade de análise e desenvolvimento de sistemas!
 * 
 * @author Jonathas Rocha de Souza
 */
public class CriptografiaJonathas {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		menu();
	}
	
	/**
	 * 
	 */
	static void menu() {
		Scanner option = new Scanner (System.in);
		
		System.out.print("##-- Digite o número de uma opção: --##\n\n");
		System.out.print("|-------------------------|\n");
		System.out.print("| 1 - Criptografar 		\n");
		System.out.print("| 2 - Descriptografar  	\n");
		System.out.print("| 3 - Sair              	\n");
		System.out.print("|-------------------------|\n");
		System.out.print("Digite uma opção: ");
		
		int opcao = option.nextInt();
		
		switch (opcao) {
		case 1:
			System.out.print("\nOpção de CRIPTOGRAFIA selecionada");
			opcaoCriptografar();
			
			break;
		
		case 2:
			System.out.print("\nOpção de DESCRIPTOGRAFIA selecionada\n");
			opcaoDescriptografar();
			
			break;
		
		default:
			System.out.print("\nOpção Inválida!");
			break;
			
		case 3:
			System.out.print("\nAté logo!");
			option.close();		
		}
		
	
	}
	
	/**
	 * 
	 */
	static void opcaoPos() {
		Scanner option = new Scanner (System.in);
		
		System.out.print("\nDeseja continuar ou sair?");
		System.out.print("\n1 - Continuar");
		System.out.print("\n2 - Sair");
		System.out.print("\nDigite uma opção: ");
		
		int opcao = option.nextInt();
		
		switch (opcao) {
		case 1:
			System.out.print("\n");
			menu();
			
			break;
		
		default:
			System.out.print("\nOpção Inválida!");
			break;
			
		case 2:
			System.out.print("\nAté logo!");
			option.close();		
		}
		
	}
	
	/**
	 * 
	 */
	static void opcaoCriptografar() {
	    System.out.println("\n\nEscreva a mensagem que deseja criptografar: ");
	    Scanner msgIn = new Scanner(System.in);
	    
	    String msg = msgIn.nextLine();
	    
	    System.out.println("\nSua mensagem: " + msg);
	    System.out.println("\nMensagem criptografada: " + criptografia(msg));
	    System.out.println("\nSua chave é: " + returnChave);
	    
	    opcaoPos();
	}
	
	/**
	 * 
	 */
	static void opcaoDescriptografar() {
	    System.out.println("\n\nEscreva a mensagem criptografada, que deseja descriptografar: ");
	    Scanner msgIn = new Scanner(System.in);
	    String msg = msgIn.nextLine();
	    
	    System.out.println("\nDigite a chave: ");
	    Scanner keyIn = new Scanner(System.in);
	    String key = keyIn.nextLine();
	    
	    System.out.println("\nSua mensagem: " + descriptografia(msg, key));
	    
	    opcaoPos();
	}
	
	/**
	 * 
	 */
	private static String[] letras = {" ", "a", "b", "c", "d", "e", 
									  "f", "g", "h", "i", "j", "k", 
									  "l", "m", "n", "o", "p", "q", 
									  "r", "s", "t", "u", "v", "w", 
									  "x", "y", "z"};
	
	/**
	 * 
	 */
	private static String[] numeros = {"00", "01", "02", "03", "04", "05", 
									   "06", "07", "08", "09", "10", "11", 
									   "12", "13", "14", "15", "16", "17", 
									   "18", "19", "20", "21", "22", "23", 
									   "24", "25", "26"};
	
	private static String returnChave = "";
	
	private static String criptografia(String msg) { // TODO: ALTERAR
		
		// Deixa o texto todo em minusculo (lowerCase)
		String textLower = msg.toLowerCase();
		
		// separa cada letra e espaços em um array
		String[] msgArray = textLower.split("");
		
		// converte o array de letras em números
		String msgToNumber = convertInNumber(msgArray);
		
		// separa em array a conversão de letras em números
		String[] msgArrayNumberString = msgToNumber.split("(?<=\\G.{2})");
		
		// separa em array de inteiros
		int[] msgArrayNumberInt = convertMsgToIntArray(msgArrayNumberString);
		
		// retorna o valor máximo para sortear, retorna em inteiro
		int[] maxSorterInt = maxSorterNumbersInt(msgArrayNumberString);
		
		// retorna o valor máximo para sortear, retorna em string
		String[] maxSorterString = maxSorterNumbersString(maxSorterInt);
		
		// chave - retorna um array com os valores da chave sorteados, retorna em inteiro
		int[] chave = chaveInt(maxSorterInt);
		
		// chave - retorna a chave em String, será passada para o usuário
		String chaveString = chaveString(chave);
		
		// atribui a chave para que possa ser possível retornar ao usuário!
		returnChave = chaveString;
		
		// mensagem criptografada em String
		String msgCriptografada = criptografar(msgArrayNumberInt, chave);
		
		return msgCriptografada;
	}
	
	/**
	 * 
	 * @param textArray
	 * @return
	 */
	private static String convertInNumber(String[] textArray) {
		String stringToNumberCripto = "";
		
		int iN = 0;
		for (int i = 0; i <= letras.length && iN < textArray.length; i++) {
			if (textArray[iN].compareTo(letras[i]) == 0) {
				stringToNumberCripto = stringToNumberCripto + numeros[i];
				
				i = -1;
				iN++;
			}
		}
		
		return stringToNumberCripto;
	}
	
	/**
	 * 
	 * @param textArray
	 * @return
	 */
	private static int[] convertMsgToIntArray(String[] textArray) {
		int[] arrayMsgInt = new int[textArray.length];
		
		int iN = 0;
		for (int i = 0; i <= letras.length && iN < textArray.length; i++) {
			if (textArray[iN].compareTo(numeros[i]) == 0) {
				arrayMsgInt[iN] = i;
				
				i = -1;
				iN++;
			}
		}
		
		return arrayMsgInt;
	}
	
	/**
	 * 
	 * @param msgArrayNumber
	 * @return
	 */
	private static int[] maxSorterNumbersInt(String[] msgArrayNumber) {
		
		int[] max = {26, 26, 26, 26, 26};
		
		int iN = 0;
		int count = 0;
		
		for (int i = 0; i <= 26; i++) {
			
			if (iN < msgArrayNumber.length && count < msgArrayNumber.length) {
				
				if (msgArrayNumber[count].compareTo(numeros[i]) == 0) {
					if ((26 - i) < max[iN])  {
						max[iN] = (26 - i);
					}
					
					iN++;
					i = -1;
					count++;
					
					if (iN > 4)  {
						iN = 0;
					}
				}
			}
		}
		
		return max;
	}
	
	/**
	 * 
	 * @param msgArrayNumber
	 * @return
	 */
	private static String[] maxSorterNumbersString(int[] msgArrayNumber) {
		
		String[] maxString = new String[msgArrayNumber.length];
		
		for (int i = 0; i <= 4; i++) {
			maxString[i] = numeros[msgArrayNumber[i]];
		}
		
		return maxString;
	}
	
	/**
	 * 
	 * @param max
	 * @return
	 */
	private static int[] chaveInt(int[] max) {
		
		int[] chave = new int[5];
		
		for (int i = 0; i < 5; i++) {
			Random random = new Random();
			int number = 0;
			
			if (max[i] > 0) {
				number = random.nextInt(max[i]);
			}
			
			chave[i] = number;
		}
		
		return chave;	
	}
	
	/**
	 * 
	 * @param max
	 * @return
	 */
	private static String chaveString(int[] max) {
		String chaveString = "";
		
		for (int i = 0; i < 5; i++) {
			chaveString = chaveString + numeros[max[i]];
		}
		
		return chaveString;	
	}
	
	/**
	 * 
	 * @param msgInInt
	 * @param chave
	 * @return
	 */
	private static String criptografar(int[] msgInInt, int[] chave) {
		String msgCriptografada = "";
		
		int iN = 0;
		for (int i = 0; i < msgInInt.length || iN <= 4; i++) {
			if (i < msgInInt.length) {
				msgCriptografada = msgCriptografada + numeros[(msgInInt[i]+chave[iN])];

				iN++;
				if (iN > 4)  {
					iN = 0;
				}
			} else {
				msgCriptografada = msgCriptografada + numeros[chave[iN]];
				iN++;
			}
		}
		
		return msgCriptografada;
	}
	
	/**
	 * 
	 * @param msg
	 * @param key
	 * @return
	 */
	private static String descriptografia(String msg, String key) {
		String msgDescriptografada = ""; 
		
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
		
		for (int i = 0; i < msgEnd.length; i++) {
			msgDescriptografada = msgDescriptografada + msgEnd[i];
		}
		
		return msgDescriptografada.toUpperCase();
	}
	
}

// Desenvolvido por Jonathas Rocha de Souza ©
