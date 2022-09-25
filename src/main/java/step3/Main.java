package step3;

import step3.domain.Car;
import step3.service.CarPlay;
import step3.service.InputReview;
import step3.service.ResultView;

public class Main {

    public static void main(String[] args) {

        Car car = new Car();
        InputReview inputReview = new InputReview(car);
        inputReview.inputCarNumber();
        inputReview.inputAttemptNumber();

        CarPlay carPlay = new CarPlay(car);

        ResultView resultView = new ResultView(car, carPlay);
        resultView.printTotalCarStatus();

    }
}
