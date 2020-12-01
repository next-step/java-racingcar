package com.woowahan.calculator;

public class Validator {

	public static void validateInput(String value) {
		throw new RuntimeException("null, 빈값 체크 등의 validation을 수행한다.");
	}
}
