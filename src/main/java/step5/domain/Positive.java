package step5.domain;

public class Positive {
    private int number;

    public Positive(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("양수만 입력이 가능합니다.");
        }
        this.number = number;
    }

    public Positive() {
    }

    public void move(int number) {
        this.number += number;
        if (number < 0) {
            this.number = 0;
        }
    }

    public int number() {
        return this.number;
    }

    public boolean equalsNumber(int winPosition) {
        return this.number == winPosition;
    }
}
