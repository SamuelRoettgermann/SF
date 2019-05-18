import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class XP_pro_level {

	public XP_pro_level() {
		// TODO Auto-generated constructor stub
	}

	public static String parseBigNumberAL(int eingabe) {
		ArrayList<String> AL = new ArrayList<String>();
		String restzahl = Integer.toString(eingabe);
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
		// Anfangseingabe - Anfang
		System.out.print(
				"Bis zu welchem Level willst du die ben�tigten XP wissen? (Weniger als 3 ist nicht m�glich und wird automatisch hochkorrigiert)"
						+ "\n" + ">> ");
		Scanner s = new Scanner(System.in);
		if (s.hasNextInt()) {
		} else {
			main(args);
			System.exit(0);
		}
		int UserInput = s.nextInt() + 1;
		if (UserInput < 4) {
			UserInput = 4;
		}
		s.close();

		// Anfangseingabe - Ende

		// Punkteberechnung - Anfang
		int[] maxep = new int[UserInput];
		maxep[0] = 0;
		maxep[1] = 400;
		maxep[2] = 900;
		maxep[3] = 1400;
		BigInteger[] totalmaxep = new BigInteger[UserInput];
		totalmaxep[0] = new BigInteger("0");
		totalmaxep[1] = new BigInteger("400");
		totalmaxep[2] = new BigInteger("1300");
		totalmaxep[3] = new BigInteger("2700");
		System.out.println("\n" + "1: " + maxep[1] + "					Insgesamt ben�tigte XP: "
				+ parseBigNumberBIAL(totalmaxep[1]) + "\n" + "2: " + maxep[2]
				+ "					Insgesamt ben�tigte XP: " + parseBigNumberBIAL(totalmaxep[2]) + "\n" + "3: "
				+ parseBigNumberAL(maxep[3]) + "				Insgesamt ben�tigte XP: "
				+ parseBigNumberBIAL(totalmaxep[3]));

		for (int i = 4; i < maxep.length; i++) {
			if (maxep[i - 1] == 1500000000) {
				maxep[i] = 1500000000;
			} else {
				maxep[i] = maxep[i - 1] + maxep[i / 2] / 3 + maxep[i / 3] / 4;
				maxep[i] /= 5;
				maxep[i] *= 5;
				if (maxep[i] >= 1500000000) {
					maxep[i] = 1500000000;
				}
			}
			totalmaxep[i] = new BigInteger(totalmaxep[i-1].toString()).add(BigInteger.valueOf(maxep[i]));
			
			System.out.print(i + ": " + parseBigNumberAL(maxep[i]));
			
			if (String.valueOf(maxep[i]).length() <= 8) {
				System.out.println("				Insgesamt ben�tigte XP: " + parseBigNumberBIAL(totalmaxep[i]));
			} else {
				System.out.println("			Insgesamt ben�tigte XP: " + parseBigNumberBIAL(totalmaxep[i]));
			}

		}

		// Punkteberechnung - Ende

		/**
		 * Der Part hier herunter funktioniert noch nicht! Endzeile zum resetten oder
		 * beenden des Programms
		 */
		System.out.print(
				"\n" + "Gib 'quit' ein um das Programm zu beenden oder 'reset' um es neuzustarten" + "\n" + ">> ");
		Scanner c = new Scanner(System.in);
//		for(int z = 0; z<maxep.length+2; z++) {
//			c.nextLine();
//		}
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//		}
		while (c.hasNextLine()) {
			String EndInput = c.nextLine();
			c.close();
			if (EndInput.equalsIgnoreCase("quit")) {
				System.exit(0);
			} else {
				if (EndInput.equalsIgnoreCase("reset")) {
					main(args);
					System.exit(0);
				} else {
					System.out.println("Falsche Eingabe! Das Programm wird jetzt geschlossen");
					System.exit(1);
				}
			}
		}
	}
}
