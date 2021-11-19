package racingcar.service;

import racingcar.domain.RacingCars;
import racingcar.domain.value.Round;

import java.util.List;

public class RacingGameService {

    private RacingCars cars;
    private Round round;

    private RacingGameService(List<String> carName, Round tryCount) {

        cars = RacingCars.from(carName);
        this.round = tryCount;
    }

    public static RacingGameService ready(List<String> carName, Round tryCount) {

        return new RacingGameService(carName,tryCount);
    }

    public void race() {
        if(round.getRound() < 1) {
            throw new IllegalArgumentException("0 이하 값은 불가능 합니다.");
        }
        cars.playTheGame();
        round.minus();
    }

    public boolean isEndGame() {
        return round.getRound() == 0;
    }

    public RacingCars getCars() {
        return cars;
    }
}
