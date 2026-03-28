package Logic;

import java.util.Scanner;

public class logic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		String pass = sc.next();
		
		System.out.println(char_check(pass));
		System.out.println(length_check(pass));

	}

	private static boolean char_check(String pass) {
		boolean upp = false;
		boolean low = false;
		boolean sp = false;
		boolean num = false;

		boolean f = false;

		for (int i = 0; i < pass.length(); i++) {
			char ch = pass.charAt(i);
			if (ch >= 'A' && ch <= 'Z') {
				upp = true;
			}
			if (ch >= 'a' && ch <= 'z') {
				low = true;
			}
			if (ch >= 48 && ch <= 57) {
				num = true;
			}
			if ((ch >= 33 && ch <= 47) || (ch >= 58 && ch <= 64) || (ch >= 91 && ch <= 96)
					|| (ch >= 123 && ch <= 126)) {
				sp = true;
			}
		}
		if ((upp == true && low == true) && (sp == true && num == true)) {
			f = true;
		}
		return f;
	}

	private static boolean length_check(String pass) {
		int l = pass.length();
		if (l >= 8) {
			return true;
		}
		return false;
	}

}
