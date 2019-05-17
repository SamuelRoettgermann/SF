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
		System.out.print(
				"Bis zu welchem Level willst du die benötigten XP wissen? (Weniger als 3 ist nicht möglich und wird automatisch hochkorrigiert)"
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

		int[] maxep = new int[UserInput];
		maxep[0] = 0;
		maxep[1] = 400;
		maxep[2] = 900;
		maxep[3] = 1400;
		System.out.println("\n" + "1: " + maxep[1] + "					Insgesamt benötigte XP: 400" + "\n" + "2: "
				+ maxep[2] + "					Insgesamt benötigte XP: 1.300" + "\n" + "3: "
				+ parseBigNumberAL(maxep[3]) + "				Insgesamt benötigte XP: 2.700");

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
			// System.out.println(i + ": " + parseBigNumber(maxep[i]));
			System.out.print(i + ": " + parseBigNumberAL(maxep[i]));
			BigInteger x = new BigInteger("0");
			for (int j = 1; j <= i; j++) {
				x = x.add(BigInteger.valueOf(maxep[j]));
			}
			if (String.valueOf(maxep[i]).length() <= 8) {
				System.out.println("				Insgesamt benötigte XP: " + parseBigNumberBIAL(x));
			} else {
				System.out.println("			Insgesamt benötigte XP: " + parseBigNumberBIAL(x));
			}

		}

		/**
		 * Der Part hier herunter funktioniert noch nicht!
		 * Part beneath this not yet working!
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
