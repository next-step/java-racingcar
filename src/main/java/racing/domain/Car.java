package racing.domain;

public class Car {
    private static final int CONDITION_FOR_MOVE = 4;
    private static final int CONDITION_FOR_NAME_LENGTH = 5;

    private int distance;
    private String name;

    public Car(String name) {
        this.distance = 0;
        validateLength(name);
        this.name = name;
    }

    public Car(String name, int distance) {
        this.distance = distance;
        validateLength(name);
        this.name = name;
    }

    private static void validateLength(String name) {
        if (name.length() > CONDITION_FOR_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5글자를 초과할 수 없습니다.");
        }
    }

    public int distance() {
        return this.distance;
    }

    public String name() {
        return name;
    }

    public void moveCar() {
        this.distance++;
    }

    public void validateForMove(int randomValue) {
        if (isMovable(randomValue)) {
            this.moveCar();
        }
    }

    private static boolean isMovable(int randomValue) {
        return randomValue >= CONDITION_FOR_MOVE;
    }

    public Boolean isThisWinningWithOthers(int highestDistance) {
        if (distance == highestDistance) {
            return true;
        }
        return false;
    }

    public Boolean isThisWinningAlone(int highestDistance) {
        if (distance > highestDistance) {
            return true;
        }
        return false;
    }

    public int presentHigherDistance(int highestDistance) {
        if (distance > highestDistance) {
            return distance;
        }
        return highestDistance;
    }
}
