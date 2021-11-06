package edu.nextstep.camp;

public class Car {
    private int position;

    public Car() {
        position = 0;
    }

    public int position() {
        return position;
    }

    public void move() {
        position++;
    }
}
