package racing.domain;

public class Car {
    private static final int MOVABLE_LOWER_BOUND = 4;
    private static final int DEFAULT_START_LOCATION = 0;
    private static final int MINIMUM_NAME_LENGTH = 5;

    private final String name;
    private int currentLocation;

    public int getCurrentLocation() {
        return currentLocation;
    }

    public String getName() {
        return name;
    }

    public Car(String name, int currentLocation) {
        if (name.length() > MINIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차의 이름은 다섯 글자를 초과할 수 없습니다.");
        }

        this.name = name;
        this.currentLocation = currentLocation;
    }

    public Car(String name) {
        this(name, DEFAULT_START_LOCATION);
    }

    public void move(int movePoint) {
        if (isMove(movePoint)) {
            currentLocation++;
        }
    }

    public boolean isSameLocation(int location) {
        return currentLocation == location;
    }

    private boolean isMove(int movePoint) {
        return movePoint >= MOVABLE_LOWER_BOUND;
    }
}
