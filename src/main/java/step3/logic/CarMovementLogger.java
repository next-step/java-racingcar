package step3.logic;

public class CarMovementLogger {
    private int carMovement;

    public CarMovementLogger() {
        this.carMovement = 0;
    }

    public void makeCarMove(boolean isCarMoving) {
        if (isCarMoving) {
            this.carMovement++;
        }
    }

    public int getCarMovementLog() {
        return this.carMovement;
    }

}
