package car_racing;

import java.util.Random;

public class Car {

    private Integer currentPosition;
    private Integer remainingMoves;

    public Car(Integer currentPosition, Integer remainingMoves) {
        this.currentPosition = currentPosition;
        this.remainingMoves = remainingMoves;
    }

    public void move() {
        currentPosition += new Random().nextInt(10);
        remainingMoves--;
    }

    public Integer getCurrentPosition() {
        return this.currentPosition;
    }
}
