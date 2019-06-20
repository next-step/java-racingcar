package racing.domain;

import racing.domain.strategy.DrivingStrategy;

public class Car {
    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
        position = 0;
    }

    public void goOrNot(DrivingStrategy strategy) {
        if (strategy.isMovable()) {
            go();
        }
    }

    private void go() {
        position++;
    }

    public String getMovesRoad() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < this.position; i++) {
            builder.append("-");
        }

        return builder.toString();
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}