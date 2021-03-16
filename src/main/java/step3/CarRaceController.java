package step3;

import step3.domain.Cars;
import step3.view.InputView;
import step3.view.ResultView;

public class CarRaceController {

    Cars cars;

    InputView inputView;

    ResultView resultView;

    public CarRaceController() {
        this.cars = new Cars();
        this.inputView = new InputView();
        this.resultView = new ResultView();
    }

    public void start(){

        inputView.inputData();

        cars.createCarList(inputView.getCarCount());

        cars.playGame(inputView.getRacingCount(), resultView);
    }
}
