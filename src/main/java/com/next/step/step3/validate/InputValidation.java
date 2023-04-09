package com.next.step.step3.validate;

public class InputValidation {

    public void validateNotNegative(int numOfCars, int numOfAttempts) {
        if (numOfCars < 0 || numOfAttempts < 0) {
            throw new RuntimeException("입력에 음수 값이 포함될 수 없습니다.");
        }
    }

    public void validateCanRacingGame(int numOfCars, int numOfAttempts) {
        if (numOfCars == 0) {
            throw new RuntimeException("최소 1대의 차량이 필요합니다.");
        }

        if (numOfAttempts == 0) {
            throw new RuntimeException("최소 1번의 경기는 진행되어야 합니다.");
        }
    }
}
