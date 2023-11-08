package racingcar;

public class Car {

    private int distance;

    protected int getDistance() {
        return distance;
    }

    protected void move(int randomNumber) {
        if (randomNumber > 3) {
            distance++;
        }
    }

}
