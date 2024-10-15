package com.racing.domain;

public class Car {

    private Position position;
    private CarName carName;

    // 기본 생성자
    public Car() {
        this(0, ""); // 기본값 0으로 다른 생성자 호출
    }

    // 상태 지정 생성자
    public Car(int position, String carName) {
        this.position = new Position(position);
        this.carName = new CarName(carName);
    }

    public void move(boolean isMovable) {
        if (isMovable) {
            position.addPosition();
        }
    }

    public String displayRacingPosition() {
        return carName.getCarName() + " : " + position.displayDashAsPosition();
    }

    public String displayCarName() {
        return carName.getCarName();
    }

    public int getPosition() {
        return position.getPosition();
    }

    public boolean isDefeated(int verseState) {
        return position.isBiggerThanPosition(verseState);
    }
}
