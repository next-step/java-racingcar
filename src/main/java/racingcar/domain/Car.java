package racingcar.domain;

import racingcar.strategy.NumberGeneratorStrategy;

public class Car {
    private final Point point;
    private final Name name;

    public Car(String carName) {
        this(0, carName);
    }

    public Car(int point, String name) {
        this.point = new Point(point);
        this.name = new Name(name);
    }

    public Point move(NumberGeneratorStrategy numberGeneratorStrategy) {
        final int number = numberGeneratorStrategy.generateNumber();
        return numberGeneratorStrategy.isMovable(number) ? point.increasePoint() : point;
    }

    public int findCarPoint() {
        return point.getPoint();
    }

    public String findCarName() {
        return name.getName();
    }
}
