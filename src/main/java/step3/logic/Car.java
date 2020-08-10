package step3.logic;

import step3.view.output.OutputView;

import java.util.Random;

public class Car {

    private static final int CAR_GOING_DECISION_POINT = 4;
    private int carMovement = 0;

    public void makeCarMove() {
        if (CAR_GOING_DECISION_POINT <= RandomGenerator.generateRandomCount()) {
            this.carMovement++;
        }
        OutputView.printingMovement(this.carMovement);
    }
}
