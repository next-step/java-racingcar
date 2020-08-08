package step3.logic;

import step3.view.output.OutputView;

public class CarCycleRunner {

    static public void runCycle(Boolean isCarGoingForward, CarMovementLogger carMovementLogger) {

        carMovementLogger.makeCarMove(isCarGoingForward);
        OutputView.printingMovement(carMovementLogger.getCarMovementLog());
    }
}
