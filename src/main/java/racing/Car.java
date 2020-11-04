package racing;

public class Car {

    private int displacement = 0;

    public void move(boolean canMove) {
        if (canMove) {
            displacement++;
        }
    }

    public int getDisplacement() {
        return displacement;
    }
}
