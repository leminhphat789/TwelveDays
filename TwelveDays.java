package e3.chapter1;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class TwelveDays {

	private static final int NUM_DAYS = 12;
	private static final ResourceBundle BUNDLE =
			ResourceBundle.getBundle("e3.chapter1.TwelveDays");

	public static void main(String[] args) {
		System.out.println(poem());
	}
	static String day(int day) {
		return BUNDLE.getString("day." + day);
	}

	static String gift(int day) {
		return BUNDLE.getString("gift." + day);
	}

	static String firstLine(int day) {
		String template = BUNDLE.getString("firstLine");
		return MessageFormat.format(template, day(day)) + "\n";
	}

	static String allGifts(int day) {
		if (day == 0) {
			return BUNDLE.getString("connector") + " " + gift(0);
		}
		else {
			return gift(day) + "\n" + allGifts(day - 1);
		}
	}

	static String poem() {
		String poem = firstLine(0) + gift(0) + "\n\n";
		for (int day = 1; day < NUM_DAYS; day++) {
			poem += firstLine(day) + allGifts(day) + "\n\n";
		}
		return poem;
	}
}
