package racingcar.domain;

import racingcar.service.strategy.MoveStrategy;

public class RacingCar implements Car {

    private static final int THRESHOLD = 4;
    private static final int NAME_SIZE = 5;

    private final String name;
    private int position;

    public RacingCar(String name) {
        isCorrectNameSize(name);
        this.name = name;
        this.position = 0;
    }

    public RacingCar(String name, int position) {
        this(name);
        this.position = position;
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.createMoveNumber() < THRESHOLD) {
            return;
        }
        position++;
    }

    public boolean isSamePosition(int position) {
        return this.position == position;
    }

    private void isCorrectNameSize(String name) {
        if (NAME_SIZE < name.length()) {
            throw new IllegalArgumentException("자동차 이름의 길이가 5를 초과했습니다!");
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return name + " : " + position;
    }
}