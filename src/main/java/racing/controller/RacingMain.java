package racing.controller;

import racing.domain.Car;
import racing.domain.Racing;
import racing.ui.InputView;
import racing.ui.ResultView;

import java.util.List;

public class RacingMain {

    public static void main(String[] args) {
        // view
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        Car car = inputView.showView();

        Racing racing = new Racing();
        List<List<Car>> list = racing.racingStart(car.getCarCount(), car.getTryCount());

        for(List<Car> carlist : list) {
            resultView.viewResultView(carlist);
        }
    }

}
