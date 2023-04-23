package domain;

public class RacingCar {
    private static int NAME_SIZE_LIMIT = 5;
    private String name;
    private Distance distance;

    private static final int ONE_TIME_DISTANCE = 1;

    public RacingCar() {
        this.name = "";
        this.distance = new Distance();
    }

    public RacingCar(String name) {
        isNameValid(name);
        this.name = name;
        this.distance = new Distance();
    }

    public RacingCar(String name, int distance) {
        isNameValid(name);
        this.name = name;
        this.distance = new Distance(distance);
    }

    private void isNameValid(String name) {
        if (name.length() > NAME_SIZE_LIMIT) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }

    public void moveOrStop(MovingStrategy movingStrategy) {
        if (movingStrategy.movable()) {
            distance.move();
        }
    }

    public int getDistance() {
        return distance.getDistance();
    }

    public boolean isSameDistance(int maxDistance) {
        return distance.isSameDistance(maxDistance);
    }

    public String getName() {
        return name;
    }

    public String getResult() {
        return this.name + " : " + "-".repeat(this.distance.getDistance());
    }
}
