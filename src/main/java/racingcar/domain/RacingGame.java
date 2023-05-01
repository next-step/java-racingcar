package racingcar.domain;

import java.util.List;

public class RacingGame {
    private Cars cars;

    public RacingGame(String[] participants) {
        addCar(participants);
    }

    public void race() {
        cars.moveAll();
    }

    public Score score() {
        return new Score(cars.list());
    }

    public List<String> winner() {
        return Winner.getWinnerCarNames(cars);
    }

    private void addCar(String[] participants) {
        cars = new Cars(participants);
    }

}
