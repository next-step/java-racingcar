package racing.domain;


import racing.view.InputView;
import racing.view.ResultView;

public class Game {

    public void run() {
        InputView.carNamesInputView();
        String carNames = InputView.inputCarNames();

        InputView.tryCountInputView();
        int tryCount = InputView.inputValue();

        Cars cars = new Cars(carNames);

        ResultView.resultViewMessage();
        for (int i = 0; i < tryCount; i++) {
            cars.runCars();
            ResultView.printCars(cars.getCars());
        }
    }

}
