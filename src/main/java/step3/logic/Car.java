package step3.logic;

import step3.view.output.OutputView;

public class Car {

    private final int CAR_GOING_DECISION_POINT = 4;
    private int carMovement = 0;
    private String carName;

    public Car(String carName) {
        this.carName = carName;
    }

    public void makeCarMove() {
        if (this.CAR_GOING_DECISION_POINT <= RandomGenerator.generateRandomCount()) {
            this.carMovement++;
        }
        OutputView.printingMovement(this.carMovement);
    }

    public String getCarName() {
        return this.carName;
    }
}
