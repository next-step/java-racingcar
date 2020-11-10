package car.racing.domain;

import car.racing.Forwardable;

import java.util.Random;

public class Car {

    private static final int NAME_LIMIT = 5;
    private static final int LIMIT = 10;

    private int forwardCount;
    private String name;
    private final Random random = new Random();

    public Car(String name, int forwardCount) {
        if (name.length() > NAME_LIMIT) {
            throw new IllegalArgumentException("이름 길이가 너무 기네요ㅠ");
        }
        this.name = name;
        this.forwardCount = forwardCount;
    }

    public String getName() {
        return name;
    }

    public int getForwardCount() {
        return forwardCount;
    }

    public void forward(Forwardable forwardable) {
        if (forwardable.forwardable(random.nextInt(LIMIT))) {
            forwardCount++;
        }
    }
}
