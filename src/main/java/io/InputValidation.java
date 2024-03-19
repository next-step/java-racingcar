package io;

public class InputValidation {
	public void checkCarName(String name) {
		if(name.length() > 5) {
			throw new IllegalArgumentException("이름은 5자를 초과할 수 없습니다. 다시 입력해주세요.");
		}
	}

	public void checkNumberOfTrial(int numberOfTrial) {
		if(numberOfTrial <= 0) {
			throw new IllegalArgumentException("시도 횟수는 0보다 큰 숫자를 입력해야 합니다. 다시 입력해주세요.");
		}
	}
}
