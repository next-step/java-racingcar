package edu.nextstep.camp.carracing.domain;

public class Position {
    private int value;

    public Position() {
        this(0);
    }

    public Position(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("위치 값에 음수가 들어갈 수 없습니다.");
        }
        this.value = value;
    }

    public void increment() {
        this.value++;
    }

    public boolean isSame(int number) {
        return this.value == number;
    }

    public int max(int number) {
        return Math.max(this.value, number);
    }

    public int getValue() {
        return this.value;
    }
}
