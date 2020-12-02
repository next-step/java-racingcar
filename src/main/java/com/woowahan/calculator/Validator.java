package com.woowahan.calculator;

public class Validator {

	public static final String MSG_NULL_OR_EMPTY = "입력 값이 null 또는 empty 입니다.";
	public static final String MSG_TWO_BLANK = "2개 이상 연속된 빈 문자열이 있을 수 없습니다.";
	public static final String MSG_NOT_FOUND_OPERATOR = "사칙 연산 기호가 아닙니다.";
	public static final String MSG_RETURN_NULL = "널 값이 반환되었습니다.";
	public static final String MSG_NOT_A_NUMBER = "숫자 값이 아닙니다.";

	public static void validateInput(String value) {
		validateNullOrEmpty(value);
		validateTwoBlank(value);
	}

	public static void validateNullOrEmpty(String value) {
		if (value == null || value.trim().isEmpty())
			throw new IllegalArgumentException(MSG_NULL_OR_EMPTY);
	}

	public static void validateTwoBlank(String value) {
		if (value != null && value.contains("  "))
			throw new IllegalArgumentException(MSG_TWO_BLANK);
	}

	public static void validateNumber(String strNum) {
		try {
			Long.parseLong(strNum);
		} catch (NumberFormatException nfe) {
			throw new IllegalArgumentException(MSG_NOT_A_NUMBER);
		}
	}
}
