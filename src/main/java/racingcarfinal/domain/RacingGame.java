package racingcarfinal.domain;

import java.util.List;

public class RacingGame {

    private final Cars cars;
    private Rounds round;

    public RacingGame(String carNames, int tryCount) {
        this.cars = new Cars(carNames);
        this.round = new Rounds(tryCount);
    }

    public boolean isEnd() {
        return round.isEnd();
    }

    public void play() {
        round.play();
        cars.move();
    }

    public List<Car> findWinners() {
        return cars.findWinners();
    }

    public Cars getCars() {
        return this.cars;
    }

}
