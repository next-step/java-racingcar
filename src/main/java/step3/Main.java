package step3;

import step3.domain.Car;
import step3.service.CarPlay;
import step3.service.InputView;
import step3.service.ResultView;

public class Main {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        inputView.inputCarNumber();
        inputView.inputAttemptNumber();
        Car car = new Car();

        CarPlay carPlay = new CarPlay(car, inputView);

        ResultView resultView = new ResultView(carPlay, inputView);
        resultView.printTotalCarStatus();

    }
}
