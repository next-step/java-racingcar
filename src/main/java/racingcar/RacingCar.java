package racingcar;

import racingcar.strategy.MoveStrategy;

public class RacingCar implements Comparable<RacingCar> {
    private int position = 0;
    private String name;
    private final MoveStrategy moveStrategy;

    public RacingCar(String name, MoveStrategy moveStrategy) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
        this.name = name;
        this.moveStrategy = moveStrategy;
    }

    public void goOrStop() {
        if (moveStrategy.shouldMove()) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public int compareTo(RacingCar o) {
        return Integer.compare(position, o.position);
    }
}
