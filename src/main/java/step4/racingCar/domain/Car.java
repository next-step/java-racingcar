package step4.racingCar.domain;

import step4.racingCar.util.NumberRandomUtil;

public class Car {
    private static final int CONDITION = 4;
    private static final int INITIAL_POSITION = 1;
    private static final int POSITION_MOVE = 1;
    private static final int NAME_LENGTH = 5;

    private int position;
    private final String name;

    public Car(String name) {
        validateNameLength(name);
        this.name = name;
        this.position = INITIAL_POSITION;
    }

    private void validateNameLength(String name) {
        if (name.length() > NAME_LENGTH) {
            throw new RuntimeException("자동차의 이름은 5글자를 초과할 수 없습니다.");
        }
    }
    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void move() {
        if (NumberRandomUtil.generate() >= CONDITION) {
            position += POSITION_MOVE;
        }
    }

    // 테스트용: 랜덤 숫자를 직접 주입할 수 있는 메서드
    public void move(int randomNumber) {
        if (randomNumber >= CONDITION) {
            position += POSITION_MOVE;
        }
    }
}

