package step3;

public class Car {

    private int location = 0;

    private final MoveStrategy moveStrategy = new RandomStrategy();

    public void move() {
        if (moveStrategy.move()) {
            goForward();
        }
    }

    private void goForward() {
        location++;
    }

    public int getLocation() {
        return location;
    }

}
