package carracing;

public class Car {

    private int distance;

    private String movedState;

    public Car() {
        this.movedState = "";
    }

    public void assignRandomDistance(int randomNumber) {
        this.distance = randomNumber;
    }

    public Integer getDistance() {
        return this.distance;
    }

    public Boolean isMovable() {
        if (distance < 4) {
            return false;
        }
        return true;
    }

    public void move() {
        if (isMovable()) {
            this.movedState += "-";
        }
    }

    public void printMovedState() {
        InputView.input(this.movedState);
        OutputView.print();
    }

    public String getMovedState() {
        return this.movedState;
    }
}
