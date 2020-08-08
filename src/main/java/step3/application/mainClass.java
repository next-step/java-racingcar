package step3.application;

import step3.logic.CarCycleRunner;
import step3.logic.CarMovement;
import step3.logic.CarMovementLogger;
import step3.view.input.InputScanner;
import step3.view.input.InputView;
import step3.view.output.OutputView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class mainClass {

    public static void main(String[] args) {
        InputView.CAR_COUNT_VIEW.printQuestion();
        int inputCarCount = InputScanner.scanInput();

        InputView.CYCLE_COUNT_VIEW.printQuestion();
        int inputCycleCount = InputScanner.scanInput();

        List<CarMovementLogger> carMovementLogger = Stream.generate(CarMovementLogger::new)
                .limit(inputCarCount)
                .collect(Collectors.toList());

        for (int i = 0; i < inputCycleCount; i++) {
            for (int j = 0; j < inputCarCount; j++) {
                CarCycleRunner.runCycle(CarMovement.isCarGoingForward(), carMovementLogger.get(j));
            }
            OutputView.printingNewLine();
        }
    }
}
