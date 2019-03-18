package racing;

public class CarRoundResult implements Comparable<CarRoundResult> {
    private int movePosition;
    private String carName;

    CarRoundResult(String carName, int movePoint) {
        this.carName = carName;
        this.movePosition = movePoint;
    }

    public int getMovePosition() {
        return this.movePosition;
    }

    public String getCarName() {
        return this.carName;
    }

    @Override
    public int compareTo(CarRoundResult o) {
        if (this.movePosition < o.movePosition) {
            return -1;
        } else if (this.movePosition > o.movePosition) {
            return 1;
        }

        return 0;
    }
}
