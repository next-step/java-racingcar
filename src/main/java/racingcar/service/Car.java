package racingcar.service;

public class Car {
    private int distance;
    private String name;
    private static int START = 0;

    public Car(String name) {
        this.name = name;
        this.distance = START;
    }

    public int drive()
    {
        return ++distance;
    }

    public int getDistance()
    {
        return distance;
    }

    public String getName() {
        return name;
    }
}
