package com.woowahan.racing.view;

import java.util.Scanner;

import com.woowahan.racing.constant.Message;
import com.woowahan.racing.util.ValidationUtil;

public class InputView {

	private static final Scanner scanner = new Scanner(System.in);

	public static int getCarCount() {
		System.out.println("자동차 대수는 몇 대 인가요?");
		String input = scanner.nextLine();
		if (!ValidationUtil.validate(input)) {
			System.out.println(Message.MSG_POSITIVE_NUMBER);
			return getCarCount();
		}
		return Integer.parseInt(input);
	}

	public static int getTryCount() {
		System.out.println("시도할 회수는 몇 회 인가요?");
		String input = scanner.nextLine();
		if (!ValidationUtil.validate(input)) {
			System.out.println(Message.MSG_POSITIVE_NUMBER);
			return getTryCount();
		}
		return Integer.parseInt(input);
	}
}
