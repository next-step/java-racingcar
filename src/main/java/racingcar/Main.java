package racingcar;

import java.util.Scanner;

import racingcar.domain.CarSimulator;
import racingcar.exception.InvalidInputException;
import racingcar.io.InputView;
import racingcar.io.OutputView;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in));

        try {
            CarSimulator simulator = new CarSimulator(inputView.getCarCount(), inputView.getMovementCount());
            simulator.simulate();

            OutputView outputView = new OutputView(simulator);
            outputView.printPositions();
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        }
    }
}
