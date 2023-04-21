package racingCarGame.domain;

public class Car {
    private int distance = 0;
    private final String owner;

    public Car(String owner) {
        this.owner = owner;
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.isCanMove()) {
            distance += 1;
        }
    }
    public boolean isEqualDistance(int maxScore) {
        return this.distance == maxScore;
    }

    public int getDistance() {
        return distance;
    }

    public String getOwner() {
        return owner;
    }
}
