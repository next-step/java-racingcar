package com.woowahan.racing.util;

public class ValidationUtil {

	public static boolean validate(String strNum) {
		return isNumber(strNum) && isPositve(strNum);
	}

	public static boolean isPositve(String strNum) {
		int num = Integer.parseInt(strNum);
		return num > 0;
	}

	public static boolean isNumber(String strNum) {
		if (strNum == null) {
			return false;
		}
		try {
			Integer.parseInt(strNum);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

}
