package racing.domain;


import racing.view.InputView;
import racing.view.ResultView;

public class Game {

    public void run() {
        InputView.carNumberInputView();
        Cars cars = new Cars(InputView.inputValue());
        InputView.tryCountInputView();

        ResultView.resultViewMessage();
        int tryCount = InputView.inputValue();

        for (int i = 0; i < tryCount; i++) {
            cars.runCars();
            ResultView.printCars(cars.getCarList());
        }
    }

}
