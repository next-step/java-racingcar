package com.next.step.step3.validate;

public class InputValidation {

    public void validateNotNegative(int inputNum) {
        if (inputNum < 0) {
            throw new RuntimeException("입력에 음수 값이 포함될 수 없습니다.");
        }
    }

    public void validateExistName(String name) {
        if (name == null || name.isEmpty()) {
            throw new RuntimeException("빈 문자열이나 NULL값은 입력할 수 없습니다.");
        }
    }

    public void validateNumOfAttempts(int numOfAttempts) {
        if (numOfAttempts == 0) {
            throw new RuntimeException("최소 1번의 경기는 진행되어야 합니다.");
        }
    }
}
