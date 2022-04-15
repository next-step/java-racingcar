package model;

public class Car {
    private int position;

    public void move(MovingRule movingRule) {
        if (movingRule.isMoveForward()) {
            this.position++;
        }
    }

    public int getPosition() {
        return position;
    }
}
