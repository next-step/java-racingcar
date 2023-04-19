package racingcar;

public class Car {
    private int distance = 0;

    public void move(int number) {
        if (number >= 4) {
            distance++;
        }
    }

    public int distanceDriven() {
        return distance;
    }

}
