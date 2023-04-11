package com.next.step.step3.validate;

import java.util.List;

public class InputValidation {

    private static final int MIN_CAR_NAME_LENGTH = 1;

    private static final int MAX_CAR_NAME_LENGTH = 5;

    public void validateNotNegative(int inputNum) {
        if (inputNum < 0) {
            throw new RuntimeException("입력에 음수 값이 포함될 수 없습니다.");
        }
    }

    public void validateExistName(String carNames) {
        if (carNames == null || carNames.isEmpty()) {
            throw new RuntimeException("빈 문자열이나 NULL값은 입력할 수 없습니다.");
        }
    }

    public void validateNumOfAttempts(int numOfAttempts) {
        if (numOfAttempts == 0) {
            throw new RuntimeException("최소 1번의 경기는 진행되어야 합니다.");
        }
    }

    public void validateCarNameLength(List<String> carNames) {
        for (String carName : carNames) {
            if (carName.length() > MAX_CAR_NAME_LENGTH) {
                throw new RuntimeException("자동차 이름의 최대 길이는 5글자입니다.");
            }
            if (carName.length() < MIN_CAR_NAME_LENGTH) {
                throw new RuntimeException("자동차 이름의 최소 길이는 1글자입니다.");
            }
        }
    }
}
