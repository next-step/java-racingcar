package racing;

import racing.car.Car;
import racing.car.Cars;
import racing.view.*;
import racing.view.request.ActionRequest;

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

        ActionRequest actionRequest;
        while((actionRequest = inputView.inputAction())
                .getAction() != InputAction.QUIT) {
            racing(cars, actionRequest);
        }
    }

    private void racing(Cars cars, ActionRequest request) {
        for (int i = 0; i < request.getTurnSize(); i++) {
            resultView.printResultTitle();
            cars.moveAll(request.getAction() == InputAction.MOVE);
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
