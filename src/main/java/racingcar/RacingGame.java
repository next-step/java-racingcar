package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private List<RacingCar> racingCars;

    RacingGame(final int numberOfCars) {
        this.racingCars = new ArrayList<>();

        this.initRacingCars(numberOfCars);
    }

    private void initRacingCars(int numberOfCars) {
        for (int iCar = 0; iCar < numberOfCars; iCar++) {
            this.racingCars.add(new RacingCar());
        }
    }

    /**
     * 총 시도 회수만큼, 각 자동차들을 랜덤하게 이동시킨후 자동차 목록을 반환한다.
     *
     * @return 자동차 목록
     */
    public List<RacingCar> play() {

        for (RacingCar racingCar : racingCars) {
            racingCar.makeRandomMove();
        }

        return this.racingCars;
    }
}
