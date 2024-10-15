package com.racing.domain;

public class Car {

    private int position = 0;
    private String name;

    // 기본 생성자
    public Car() {
        this(0, ""); // 기본값 0으로 다른 생성자 호출
    }

    // 상태 지정 생성자
    public Car(int state, String name) {
        this.position = state;
        this.name = name;
    }

    public void move(boolean isMovable) {
        if (isMovable) {
            position++;
        }
    }

    public String displayRacingPosition() {
        return displayCarName() + " : " + displayState();
    }

    public String displayState() {
        return "-".repeat(position);
    }

    public String displayCarName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public boolean isDefeated(int verseState) {
        return position < verseState;
    }
}
