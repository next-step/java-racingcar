package step5.domain;

import step5.strategy.move.MoveStrategy;

public class RacingCar {
    private final static int THRESHOLD = 5;
    private final String name;
    private int currentLocation;

    private RacingCar(String name) {
        this.name = name;
    }

    public static RacingCar of(String name) {
        validateEmpty(name);
        validateLessThen5Name(name);
        return new RacingCar(name);
    }

    private static void validateEmpty(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름을 입력해주세요");
        }
    }

    private static void validateLessThen5Name(String name){
        if(name.length() > THRESHOLD){
            throw new IllegalArgumentException("5자를 초과할수 없습니다");

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
