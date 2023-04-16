package step4.domain;

import step4.strategy.move.MoveStrategy;

public class UsingNameRacingCar {

    private final String name;
    private int currentLocation;

    private UsingNameRacingCar(String name) {
        this.name = name;
    }

    public static UsingNameRacingCar of(String name) {
        hasCarName(name);
        return new UsingNameRacingCar(name);
    }

    private static void hasCarName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름을 입력해주세요");
        }
    }

    public void move(MoveStrategy moveStrategy) {
        if (moveStrategy.isMovable()) {
            currentLocation++;
        }
    }

    public int getCurrentLocation() {
        return currentLocation;
    }

    public String getName() {
        return name;
    }
}
