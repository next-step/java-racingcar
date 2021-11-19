package racingcargamefinal.domain;

public class RacingGame {

    private Cars cars;
    private Round round;

    public RacingGame(String carNames, int tryCount) {
        this.cars = new Cars(carNames);
        this.round = new Round(tryCount);
    }

    public boolean isEnd() {
        return round.isEnd();
    }

    public void play() {
        if (!round.isEnd()) {
            round = round.play();
            cars = cars.move();
        }
    }

    public Winners findWinners() {
        return cars.findWinners();
    }

    public Cars getCars() {
        return cars;
    }

}
