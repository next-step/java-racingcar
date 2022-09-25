package racingcar.game;

import racingcar.InputView;
import racingcar.ResultView;
import racingcar.domain.Car;
import racingcar.domain.CarFacility;

import java.util.List;


public class racingCarGame {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        int carNum = inputView.createCarNum();

        int tryTimes = inputView.createTryTimes();

        CarFacility carFacility = new CarFacility();
        List<Car> carList = carFacility.buildCar(carNum);

        resultView.printResult(tryTimes, carList);

    }

}
