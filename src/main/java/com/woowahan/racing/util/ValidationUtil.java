package com.woowahan.racing.util;

public class ValidationUtil {

	public static boolean isNotNumber(String strNum) {
		if (strNum == null) {
			return true;
		}
		try {
			Integer.parseInt(strNum);
		} catch (NumberFormatException nfe) {
			return true;
		}
		return false;
	}

}
