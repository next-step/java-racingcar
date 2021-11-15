package racing.model;

public class Car {

    private static final int GO_BEHAVIOR_PIVOT = 4;
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;
    private int movingDistance = 0;

    public Car(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 5자 초과가 불가능 합니다.");
        }
        this.name = name;
    }

    public void move(int randomValue) {
        if (randomValue >= GO_BEHAVIOR_PIVOT) {
            movingDistance++;
        }
    }

    public boolean isEqualMovingDistance(int movingDistance) {
        return this.movingDistance == movingDistance;
    }

    public int getMovingDistance() {
        return movingDistance;
    }

    public String getName() {
        return name;
    }
}
