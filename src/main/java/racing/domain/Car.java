package racing.domain;

public class Car {
    private static final int CONDITION_FOR_MOVE = 4;
    private static final int CONDITION_FOR_NAME_LENGTH = 5;

    private Distance distance;
    private String name;

    public Car(String name) {
        this.distance = new Distance();
        validateLength(name);
        this.name = name;
    }

    public Car(String name, int distance) {
        this.distance = new Distance(distance);
        validateLength(name);
        this.name = name;
    }

    private static void validateLength(String name) {
        if (name.length() > CONDITION_FOR_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5글자를 초과할 수 없습니다.");
        }
    }

    public Distance distance() {
        return distance;
    }

    public String name() {
        return name;
    }

    public void moveCar() {
        distance = distance.addDistance();
    }

    public void validateForMove(int randomValue) {
        if (isMovable(randomValue)) {
            this.moveCar();
        }
    }

    private static boolean isMovable(int randomValue) {
        return randomValue >= CONDITION_FOR_MOVE;
    }

    public boolean isThisWinningWithOthers(int highestDistance) {
        return distance.isEqual(highestDistance);
    }

    public boolean isThisWinningAlone(int highestDistance) {
        return distance.isGreater(highestDistance);
    }

    public int presentHigherDistance(int highestDistance) {
        return distance.maxNum(highestDistance);
    }
}
