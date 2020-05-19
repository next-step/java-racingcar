package study.racing.model;

public class Car {
    private int count = 0;

    public int getCount() {
        return count;
    }

    public int move() {
        count++;

        return count;
    }
}
