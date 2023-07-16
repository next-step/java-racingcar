package study.step3.domain;

public class Car {
    private final int START_VALUE = 1;
    private int position = START_VALUE;

    public void move() {
        this.position++;
    }
}
