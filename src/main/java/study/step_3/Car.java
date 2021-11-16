package study.step_3;

public class Car {

    private final int condition = 4;
    private int distance;

    public void move() {
        distance++;
    }

    public boolean canMove(int randomNumber) {
        return randomNumber >= condition;
    }

    public int getDistance() {
        return distance;
    }
}
