package step3;

public class Car {
    private int moveDistance;
    private String moveStatus;

    private static final int MOVE_CRITERION = 4;

    public Car() {
        this.moveDistance = 0;
        this.moveStatus = new String();
    }

    public int getMoveDistance() {
        return moveDistance;
    }

    public String getMoveStatus() {
        return moveStatus;
    }

    public void moveForward(int number) {
        if (checkProgressPossible(number)) {
            addMoveDistance();
            updateMoveStatus();
        }
    }

    public void addMoveDistance() {
        this.moveDistance += 1;
    }

    public void updateMoveStatus() {
        this.moveStatus += "-";
    }

    private boolean checkProgressPossible(int number) {
        return number >= MOVE_CRITERION;
    }
}
