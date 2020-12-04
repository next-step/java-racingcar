package com.woowahan.racing.view;

import java.util.Scanner;

import com.woowahan.racing.constant.Message;
import com.woowahan.racing.util.ValidationUtil;

public class InputView {

	private static final Scanner scanner = new Scanner(System.in);

	public static int getCarCount() {
		System.out.println(Message.MSG_CAR_NAME);
		String input = scanner.nextLine();
		if (!ValidationUtil.validate(input)) {
			System.out.println(Message.MSG_POSITIVE_NUMBER);
			return getCarCount();
		}
		return Integer.parseInt(input);
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
