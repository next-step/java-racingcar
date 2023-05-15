package racinggame.domain;

public class Car {
    public static final int CAR_NAME_STANDARD = 5;
    private int location;
    private String name;

    public Car() {
    }

    public Car(String name) {
        if (name.length() > CAR_NAME_STANDARD) {
            throw new IllegalArgumentException(String.format("자동차 이름은 %d자를 초과할 수 없습니다.", CAR_NAME_STANDARD));
        }
        this.name = name;
        this.location = getLocation();
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.movable()) {
            location += 1;
        }
    }

    public int getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public boolean isWinner(int winnerLocation) {
        return this.location == winnerLocation;
    }
    
}
