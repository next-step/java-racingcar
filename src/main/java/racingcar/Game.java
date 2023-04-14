package racingcar;

public class Game {

    private final Cars cars;
    private final Round round;

    public Game(final int count, final int number) {
        this.cars = new Cars(count);
        this.round = new Round(number);
    }

    public GameResult play() {
        GameResult gameResult = new GameResult();
        for (int i = 0; i < round.getNumber(); i++) {
            gameResult.input(round());
        }
        return gameResult;
    }

    private RoundResult round() {
        RoundResult roundResult = new RoundResult();
        for (final Car car : this.cars.getCars()) {
            car.racing();
            roundResult.input(car.getPosition());
        }
        return roundResult;
    }

}
