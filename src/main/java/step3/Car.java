package step3;

public class Car {
    private int moveDistance;
    private String moveStatus;

    public Car() {
        this.moveDistance = 0;
        this.moveStatus = new String();
    }

    public String getMoveStatus() {
        return moveStatus;
    }

    public void moveForward() {
        if (checkProgressPossible(CarUtils.getNumberForMovement())) {
            this.moveDistance += 1;
            updateMoveStatus();
        }
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
