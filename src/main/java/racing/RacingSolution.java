package racing;

import racing.car.Car;
import racing.car.Cars;
import racing.view.DosInputView;
import racing.view.DosResultView;
import racing.view.InputView;
import racing.view.ResultView;

public class RacingSolution {
    public static void main(String[] args) {
        RacingSolution racingSolution = new RacingSolution(
                new DosInputView(),
                new DosResultView()
        );
        racingSolution.run();
    }

    private InputView inputView;
    private ResultView resultView;
    public RacingSolution(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void run() {
        Cars cars = inputCars();

        int turnSize = inputView.inputTurnSize();

        resultView.printResultTitle();
        for (int i = 0; i < turnSize; i++) {
            cars.moveAll();
            resultView.printAllCarLocation(cars);
        }
    }

    private Cars inputCars() {
        Cars cars = new Cars();
        int carSize = inputView.inputCarSize();
        for (int i = 0; i < carSize; i++)
            cars.add(new Car());
        return cars;
    }
}
