package racingcar;

public class Car {
    private final String name;
    private int distance = 0;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    public void move(boolean isMove) {
        if (isMove) {
            distance++;
        }
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    private void validateName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }
}
