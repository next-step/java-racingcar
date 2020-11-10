package racingcar.domain;

import racingcar.application.number.NumberGenerator;

public class Car {

    private String name;
    private int distance;

    public Car(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public int move(NumberGenerator numberGenerator) {
        final int FORWARD_CRITERION = 4;
        int number = numberGenerator.getNumber();

        if (number >= FORWARD_CRITERION) {
            distance++;
        }
        return distance;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
