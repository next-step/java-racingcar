package step2;

import static step2.Validator.*;

public class Converter {

	public static int stringToInt(String number) {
		validateNumber(number);
		return Integer.parseInt(number);
	}
}
