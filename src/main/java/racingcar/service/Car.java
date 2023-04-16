package racingcar.service;

public class Car {
    private int distance;
    private static int START = 0;

    public Car() {
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

}
