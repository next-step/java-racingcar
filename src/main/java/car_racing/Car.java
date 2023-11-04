package car_racing;

public class Car {

    private Integer currentPosition;
    private Integer remainingMoves;

    public Car(Integer currentPosition, Integer remainingMoves) {
        this.currentPosition = currentPosition;
        this.remainingMoves = remainingMoves;
    }

    public void move(int i) {
        currentPosition += i;
    }

    public Integer getCurrentPosition() {
        return this.currentPosition;
    }
}
