package domain;

public class Car {
    private final String name;
    private int distance;
    private static final int CAR_NAME_LENGTH_BOUND = 5;

    public Car(String name) {
        validateNameLengthCheck(name);
        this.name = name;
        this.distance = 0;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void move(MovingStrategy movingStrategy) {
        if (movingStrategy.isMovable()) { //구현체가 아닌 인터페이스와 의존 관계
            this.distance += 1;
        }
    }

    public void validateNameLengthCheck(final String name) {
        if (name.length() > CAR_NAME_LENGTH_BOUND) {
            throw new IllegalArgumentException("car name is too long");
        }
    }
}
