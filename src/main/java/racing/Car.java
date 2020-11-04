package racing;

public class Car {

    private int displacement;

    public Car() {}

    public void move(boolean canMove) {
        if (canMove) {
            displacement++;
        }
    }

    public int getDisplacement() {
        return displacement;
    }
}
