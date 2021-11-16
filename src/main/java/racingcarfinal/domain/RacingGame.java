package racingcarfinal.domain;

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

}
