package com.woowahan.racing.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.woowahan.racing.constant.Message;
import com.woowahan.racing.util.ValidationUtil;

public class InputView {

	private static final Scanner scanner = new Scanner(System.in);
	private static final String NAME_DELIMITER = ",";

	public static List<String> getCarNames() {
		System.out.println(Message.MSG_CAR_NAME);
		String input = scanner.nextLine();
		if (ValidationUtil.isNullOrEmpty(input)) {
			System.out.println(Message.MSG_NULL_OR_EMPTY_CAR_NAMES);
			return getCarNames();
		}
		List<String> result = parseNames(input);
		if (ValidationUtil.hasLengthEmptyOrGreaterThanFive(result)) {
			System.out.println(Message.MSG_HAS_CAR_NAME_LENGTH_ERROR);
			return getCarNames();
		}
		return result;
	}

	private static List<String> parseNames(String input) {
		String[] splitNames = input.split(NAME_DELIMITER);
		return Arrays.asList(splitNames);
	}

	public static int getTryCount() {
		System.out.println(Message.MSG_TRY_COUNT);
		String input = scanner.nextLine();
		if (!ValidationUtil.validate(input)) {
			System.out.println(Message.MSG_POSITIVE_NUMBER);
			return getTryCount();
		}
		return Integer.parseInt(input);
	}
}
