import java.util.ArrayList;
import java.util.Scanner;
import java.math.BigInteger;

public class Grenzen_ausreizen {
	//Gleiches Problem wie bei der anderen Klasse nur in simpler
	
	public static String parseBigNumberBIAL(BigInteger eingabe) {
		ArrayList<String> AL = new ArrayList<String>();
		String restzahl = eingabe.toString();
		String output = "";
		while (restzahl.length() > 3) {
			AL.add(restzahl.substring(restzahl.length() - 3, restzahl.length()));
			restzahl = restzahl.substring(0, restzahl.length() - 3);
		}
		if (restzahl.length() > 0) {
			AL.add(restzahl);
		}

		for (int i = AL.size() - 1; i >= 0; i--) {
			if (i >= 1) {
				output = output + AL.get(i) + ".";
			} else {
				output = output + AL.get(i);
			}
		}

		return output;
	}

	public static void main(String[] args) {
		//Usereingaben - Anfang
		System.out.println("							POTENZRECHNER" + "\n" + "\n" + "\n");
		System.out.print("Gib deine Basis ein" + "\n" + ">> ");
		Scanner s = new Scanner(System.in);
		int firstInput = s.nextInt();
		System.out.print("\n" + "Gib deinen Exponenten ein" + "\n" + ">> ");
		int secondInput = s.nextInt();
		s.close();
		
		//Usereingaben - Ende

		//Berechnung und Ausgabe - Anfang
		BigInteger a = new BigInteger(Integer.toString(firstInput));

		System.out.print("\n" + "Das Ergebnis der Berechnung ist: " + parseBigNumberBIAL(a.pow(secondInput)));
		
		//Berechnung und Ausgabe - Ende

		//Programmendeingabe funktioniert nicht
		//Programmendeingabe - Anfang
		System.out.print("\n" + "\n" + "Gib 'reset' ein um das Programm neuzustarten" + "\n" + ">> ");
		Scanner c = new Scanner(System.in);
		String endInput = c.nextLine();
		c.close();
		if (endInput.equalsIgnoreCase("reset")) {
			main(args);
			System.exit(0);
		} else {
			System.exit(1);
		}
		
		//Programmendeingabe - Ende
	}
}
