package io;

import racingcar.CarValidation;

public class InputValidation {
	public static void checkCarName(String name) {
		CarValidation.checkCarName(name);
	}

	public static void checkNumberOfTrial(int numberOfTrial) {
		if(numberOfTrial <= 0) {
			throw new IllegalArgumentException("시도 횟수는 0보다 큰 숫자를 입력해야 합니다. 다시 입력해주세요.");
		}
	}
}
