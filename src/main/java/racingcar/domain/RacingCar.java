package racingcar.domain;

import racingcar.domain.strategy.MoveStrategy;

public class RacingCar implements Car {

    private static final int NAME_SIZE = 5;

    private final String name;
    private int position;

    public RacingCar(String name) {
        this(name, 0);
    }

    public RacingCar(String name, int position) {
        isCorrectNameSize(name);
        this.name = name;
        this.position = position;
    }

    public void move(MoveStrategy moveStrategy) {
        if (!moveStrategy.isMoveable()) {
            return;
        }
        position++;
    }

    public boolean isSamePosition(int position) {
        return this.position == position;
    }

    private void isCorrectNameSize(String name) {
        if(name == null || name.isEmpty()){
            throw new IllegalArgumentException("자동차 이름이 빈값입니다!");
        }
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