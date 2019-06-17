package racing;

import racing.strategy.DrivingStrategy;

public class Car {
    public int position;

    public Car() {
        position = 0;
    }

    public void goOrNot(DrivingStrategy strategy) {
        if (strategy.isMovable()) {
            go();
        }
    }

    public void go() {
        position++;
    }

    public String getMovesRoad() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < this.position; i++) {
            builder.append("-");
        }

        return builder.toString();
    }
}

