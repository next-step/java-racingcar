package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.CarDTO;
import racingcar.domain.RacingCarList;
import racingcar.domain.RandomStrategy;

import java.util.ArrayList;
import java.util.List;

public class RacingGameController {
    private List<Car> racingCars;

    public RacingGameController() {
    }

    public void createCarBy(String racingCarNameList) {
        String[] carNames = racingCarNameList.split(",");
        this.racingCars = new ArrayList<>();
        for (String carName : carNames) {
            racingCars.add(new Car(carName));
        }
    }

    public List<CarDTO> race() {
        List<CarDTO> carDTOS = new ArrayList<>();
        for (Car car : racingCars) {
            car.move(new RandomStrategy());
            carDTOS.add(car.toDTO());
        }

        return carDTOS;
    }

    public void findWinner() {

    }
}
