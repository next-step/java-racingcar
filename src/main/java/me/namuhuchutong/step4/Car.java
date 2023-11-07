package me.namuhuchutong.step4;

public class Car {

    private static final int FORWARD_VALUE = 1;

    private int position;
    private final String name;

    public static Car from(Car car) {
        return new Car(car.getPosition(), car.getName());
    }

    public Car(String name) {
        this(0, name);
    }

    public Car(int position, String name) {
        this.position = position;
        this.name = name;
    }

    void move(RacingRule racingRule) {
        if (racingRule.isSatisfiedRule()) {
            this.position += FORWARD_VALUE;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
