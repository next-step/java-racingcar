package racingcar;

import java.util.List;
import java.util.Scanner;

import racingcar.domain.Car;
import racingcar.domain.CarFactory;
import racingcar.domain.CarSimulator;
import racingcar.exception.InvalidInputException;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Main {
    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in));

        try {
            List<Car> cars = CarFactory.createCars(inputView.inputCarNames());
            CarSimulator simulator = new CarSimulator(inputView.getMovementCount(), cars);
            simulator.simulate();

            OutputView outputView = new OutputView(simulator);
            outputView.printPositions();
            outputView.printWinners();
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        }
    }
}
