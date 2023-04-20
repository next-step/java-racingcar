package racingcar.service;


public class Car {
    private int distance;
    private String name;
    private static int START = 0;
    private final int NAME_STANDARD = 5;

    public Car(String name) {
        this(name, START);
    }

    public Car(String name, int distance) {
        this.name = validateName(name);
        this.distance = distance;
    }

    private String validateName(String carName) {
        if (carName.length() > NAME_STANDARD) {
            throw new RuntimeException("over 5 length");
        }
        return carName;
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

    public int max(int distance) {
        if (distance <= this.distance) {
            return this.distance;
        }
        return distance;
    }
}
