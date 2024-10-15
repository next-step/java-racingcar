package com.racing.domain;

public class Car {

    private Position position;
    private String name;

    // 기본 생성자
    public Car() {
        this(0, ""); // 기본값 0으로 다른 생성자 호출
    }

    // 상태 지정 생성자
    public Car(int position, String name) {
        this.position = new Position(position);
        this.name = name;
    }

    public void move(boolean isMovable) {
        if (isMovable) {
            position.addPosition();
        }
    }

    public String displayRacingPosition() {
        return displayCarName() + " : " + displayState();
    }

    public String displayState() {
        return position.displayDashAsPosition();
    }

    public String displayCarName() {
        return name;
    }

    public int getPosition() {
        return position.getPosition();
    }

    public boolean isDefeated(int verseState) {
        return position.getPosition() < verseState;
    }
}
