package model;

public class MovingRule {
    public boolean isMoveForward = false;

    public MovingRule(int number) {
        int DEFAULT_MOVE_FORWARD_VALUE = 4;

        if (number >= DEFAULT_MOVE_FORWARD_VALUE) {
            this.isMoveForward = true;
        }
    }

    public boolean isMoveForward() {
        return isMoveForward;
    }
}
