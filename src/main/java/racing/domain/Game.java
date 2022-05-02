package racing.domain;

import java.util.List;

import racing.exception.GameException;

public class Game {
    private NumberOfRound numberOfRound;
    private final GameRule gameRule;
    private final RacingCars racingCars;

    public Game(final NumberOfRound numberOfRound, final GameRule gameRule, final List<String> names) {
        this.numberOfRound = numberOfRound;
        this.gameRule = gameRule;
        this.racingCars = new RacingCars(names);
    }

    public boolean isLeftRound() {
        return numberOfRound.isLeftRound();
    }

    public void proceedRound() {
        if (!isLeftRound()) {
            throw new GameException("모든 Round가 종료되었습니다.");
        }
        racingCars.run(gameRule);
        this.numberOfRound = this.numberOfRound.decrease();
    }

    public List<Car> findWinners() {
        return racingCars.findWinners();
    }

    public RacingCars getCars() {
        return racingCars;
    }

    @Override
    public String toString() {
        return "Game{" +
               "numberOfRound=" + numberOfRound +
               ", gameRule=" + gameRule +
               ", racingCars=" + racingCars +
               '}';
    }
}
