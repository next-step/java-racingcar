package carracing;

public class Car {
    private int moveStatus;

    public Car() {
        this.moveStatus = 0;
    }

    public int getMoveStatus() {
        return moveStatus;
    }

    public void move() {
        this.moveStatus += 1;
    }
}
