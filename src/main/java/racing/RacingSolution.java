package racing;

import racing.domain.car.Cars;
import racing.domain.fuel.Fuel;
import racing.domain.fuel.RandomFuel;
import racing.exception.DuplicateKeyException;
import racing.exception.EmptyCarException;
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
            Cars cars = inputView.inputCars();
            int turnSize = inputView.inputTurnSize();

            racing(cars, turnSize);

            resultView.printWinners(cars);
        } catch (EmptyCarException | InvalidInputException e) {
            resultView.printException(e);
        } catch (IllegalStateException e) {
            resultView.printException(
                    new DuplicateKeyException("중복된 자동차 이름이 존재 합니다.")
            );
        }
    }

    private void racing(Cars cars, int turnSize) {
        resultView.printResultTitle();
        Fuel randomFuel = new RandomFuel();
        for (int i = 0; i < turnSize; i++) {
            cars.moveAll(randomFuel);

            resultView.printAllCarLocation(cars);
        }
    }
}
