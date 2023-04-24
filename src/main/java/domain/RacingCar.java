package domain;

public class RacingCar {
    private static int NAME_SIZE_LIMIT = 5;
    private String name;
    private int distance;

    private static final int ONE_TIME_DISTANCE = 1;

    public RacingCar() {
    }

    public RacingCar(String name) {
        isNameValid(name);
        this.name = name;
    }

    private void isNameValid(String name) {
        if (name.length() > NAME_SIZE_LIMIT) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }

    public void moveOrStop(MovingStrategy movingStrategy) {
        if (movingStrategy.movable()) {
            this.distance += ONE_TIME_DISTANCE;
        }
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }

    public String getResult() {
        return this.name + " : " + "-".repeat(this.distance);
    }
}
