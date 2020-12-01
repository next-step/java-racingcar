package com.woowahan.calculator;

import java.util.ArrayList;
import java.util.List;

public class Parser {

	public static ParseResult parse(String input) {
		Validator.validateInput(input);
		throw new RuntimeException("파싱 후 숫자 목록과 연산자 목록으로 구분해서 ParseResult객체 형태로 담는다.");
	}
}
