package step3.model;

public class Car {

    private static final int CAR_GOING_DECISION_POINT = 4;
    private int carMovement = 0;
    private final String playerName;

    public Car(String playerName) {
        this.playerName = playerName;
    }

    public void makeCarMove() {
        if (this.CAR_GOING_DECISION_POINT <= RandomGenerator.generateRandomCount()) {
            this.carMovement++;
        }
    }

    public String getCarName() { return this.playerName; }

    public int getCarMovedCount() {
        return this.carMovement;
    }
}
