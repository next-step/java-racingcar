package racing;

public class Car {

    private int movedDistance = 0;

    public void move(int distance) {
        movedDistance += distance;
    }

    public int getMovedDistance() {
        return movedDistance;
    }
}
