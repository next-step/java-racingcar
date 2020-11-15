package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private RacingCars racingCars;

    public RacingGame() {
    }

    public void createCars(String racingCarNameList) {
        this.racingCars = new RacingCars(getRacingCarList(split(racingCarNameList)));
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

    public List<Car> race() {
        racingCars.race();
        return racingCars.getCars();
    }

    public List<Car> findWinner() {
        return racingCars.findWinners();
    }
}
