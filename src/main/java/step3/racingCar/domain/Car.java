package step3.racingCar.domain;

import step3.racingCar.util.NumberRandomUtil;

public class Car {
    private static final int CONDITION = 4;
    private static final int INITIAL_POSITION = 1;
    private int position;

    public Car() {
        this.position = INITIAL_POSITION;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        if (NumberRandomUtil.generate() >= CONDITION) {
            position += 1;
        }
    }

    // 테스트용: 랜덤 숫자를 직접 주입할 수 있는 메서드
    public void move(int randomNumber) {
        if (randomNumber >= CONDITION) {
            position += 1;
        }
    }
}

