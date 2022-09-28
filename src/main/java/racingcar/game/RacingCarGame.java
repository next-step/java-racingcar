package racingcar.game;

import racingcar.InputView;
import racingcar.MovingStrategy;
import racingcar.ResultView;
import racingcar.domain.Car;
import racingcar.domain.CarFacility;

import java.util.List;


public class RacingCarGame {

  public static void main(String[] args) {

    InputView inputView = new InputView();
    int carNum = inputView.inputCarNum();

    int tryTimes = inputView.createTryTimes();

    MovingStrategy movingStrategy = new MovingStrategy();
    CarFacility carFacility = new CarFacility();
    List<Car> cars = carFacility.buildCar(carNum);

    ResultView resultView = new ResultView();
    resultView.printResult(tryTimes, cars);

  }

}
