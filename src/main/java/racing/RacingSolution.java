package racing;

import racing.car.Car;
import racing.car.Cars;
import racing.exception.InvalidInputException;
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

    private final InputView inputView;
    private final ResultView resultView;
    private final Cars cars;
    public RacingSolution(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.cars = inputCars();
    }

    public void run() {
        try {
            for (ActionRequest actionRequest = inputView.inputAction(); !actionRequest.isQuit(); actionRequest = inputView.inputAction()) {
                racing(actionRequest);
            }
        } catch (InvalidInputException e) {
            resultView.printException(e);
            run(); // 재귀 재시작
        }
    }

    private void racing(ActionRequest request) {
        resultView.printResultTitle();
        for (int i = 0; i < request.getTurnSize(); i++) {
            cars.moveAll(request.getAction() == InputAction.MOVE);
            resultView.printAllCarLocation(cars);
        }
    }

    private Cars inputCars() {
        try {
            Cars cars = new Cars();
            int carSize = inputView.inputCarSize();
            for (int i = 0; i < carSize; i++)
                cars.add(new Car());
            return cars;
        } catch (InvalidInputException e) {
            resultView.printException(e);
            return inputCars();  // 재귀 재입력
        }
    }
}
