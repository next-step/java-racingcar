package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.CarDTO;
import racingcar.domain.RacingCarList;

import java.util.ArrayList;
import java.util.List;

public class RacingGameController {
    private RacingCarList racingCarList;

    public RacingGameController() {
    }

    public void createCarBy(String racingCarNameList) {
        String[] carNames = racingCarNameList.split(",");
        List<Car> racingCars = new ArrayList<>();
        for (String carName : carNames) {
            racingCars.add(new Car(carName));
        }

        this.racingCarList = new RacingCarList(racingCars);
    }

    public List<CarDTO> race() {
        return racingCarList.race();
    }

    public List<CarDTO> findWinner() {
        return racingCarList.findWinners();
    }
}
