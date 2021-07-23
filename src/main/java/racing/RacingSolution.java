package racing;

import racing.car.Car;
import racing.car.Cars;
import racing.car.Fuel;
import racing.exception.InvalidInputException;
import racing.view.*;

public class RacingSolution {
    public static void main(String[] args) {
        RacingSolution racingSolution = new RacingSolution(
                new DosInputView(),
                new DosResultView()
        );
        racingSolution.run();
    }

    private final InputView inputView;
    private final ResultView resultView;
    public RacingSolution(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void run() {
        try {
            Cars cars = inputCars();
            int turnSize = inputView.inputTurnSize();

            racing(cars, turnSize);
        } catch (InvalidInputException e) {
            resultView.printException(e);
        }
    }

    private Cars inputCars() {
        Cars cars = new Cars();
        int carSize = inputView.inputCarSize();
        for (int i = 0; i < carSize; i++)
            cars.add(new Car());
        return cars;
    }

    private void racing(Cars cars, int turnSize) {
        resultView.printResultTitle();
        for (int i = 0; i < turnSize; i++) {
            cars.moveAll(Fuel.randomInstance());

            resultView.printAllCarLocation(cars);
        }
    }
}
