package com.woowahan.racing.util;

import java.util.List;

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

	public static boolean isNullOrEmpty(String value) {
		return value == null || "".equals(value);
	}

	public static boolean validateCarName(String value) {
		return !isNullOrEmpty(value) && value.length() <= 5;
	}

	public static boolean allValidateName(List<String> strings) {
		return strings.stream().allMatch(ValidationUtil::validateCarName);
	}
}
