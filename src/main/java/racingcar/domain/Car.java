package racingcar.domain;

import racingcar.domain.strategy.MoveStrategy;

public class Car implements Comparable<Car>{
    private int position;

    public Car() {
        this.position = 0;
    }

    public int getPosition() {
        return position;
    }

    public void moveForward(MoveStrategy moveStrategy) {
        if (moveStrategy.isMovable()) {
            this.position++;
        }
    }

    public boolean isWinner(int winnerPosition) {
        return this.position >= winnerPosition;
    }

    @Override
    public int compareTo(Car o) {
        return Integer.compare(this.position, o.position);
    }
}
