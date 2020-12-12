package racingcar;

import racingcar.domain.Cars;
import racingcar.domain.Count;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingResult;
import racingcar.view.RacingCarInputView;
import racingcar.view.RacingCarOutView;

public class RacingCarApplication {
    public static void main(String[] args) {
        Cars intputCars = RacingCarInputView.getCars();
        Count intputCount = RacingCarInputView.getCount();
        RacingCar racingCar = new RacingCar(intputCars, intputCount);
        racingCar.start();
        Cars cars = racingCar.getCars();
        RacingResult result = cars.getRacingResult();
        RacingCarOutView.showResult(result.racingRounge());
    }
}
