package racingcar.game;

import racingcar.InputView;
import racingcar.RacingRule;
import racingcar.domain.Car;
import racingcar.domain.CarFacility;

import java.util.List;


public class RacingCarGame {

  public static void main(String[] args) {

    InputView inputView = new InputView();
    int carNum = inputView.inputCarNum();

    int tryTimes = inputView.createTryTimes();

    CarFacility carFacility = new CarFacility();
    List<Car> cars = carFacility.buildCar(carNum);

    RacingRule racingRule = new RacingRule();
    racingRule.play(tryTimes, cars);

  }

}
