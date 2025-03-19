package step3;

import java.util.Scanner;

import step3.domain.CarSimulator;
import step3.exception.InvalidInputException;
import step3.io.InputView;
import step3.io.OutputView;

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
