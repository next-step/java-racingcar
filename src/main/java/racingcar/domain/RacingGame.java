package racingcar.domain;

import racingcar.domain.Car;
import racingcar.domain.CarDTO;
import racingcar.domain.RacingCarList;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private RacingCarList racingCarList;

    public RacingGame() {
    }

    public void createCarBy(String racingCarNameList) {
        this.racingCarList = new RacingCarList(getRacingCarList(split(racingCarNameList)));
    }

    private List<Car>  getRacingCarList(String[] carNames) {
        List<Car> racingCars = new ArrayList<>();
        for (String carName : carNames) {
            racingCars.add(new Car(carName));
        }
        return racingCars;
    }

    private String[] split(String racingCarNameList) {
        return racingCarNameList.split(",");
    }

    public List<CarDTO> race() {
        return racingCarList.race();
    }

    public List<CarDTO> findWinner() {
        return racingCarList.findWinners();
    }
}
