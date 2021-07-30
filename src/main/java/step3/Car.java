package step3;

public class Car {
    private int moveDistance;
    private String moveStatus;

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

    public void moveForward() {
        if (checkProgressPossible(CarUtils.getNumberForMovement())) {
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

    public boolean checkProgressPossible(int number) {
        if (number >= 4) {
            return true;
        }
        return false;
    }
}
