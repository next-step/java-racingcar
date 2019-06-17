package camp.nextstep.edu.racingcar.domain;

import camp.nextstep.edu.util.AssertUtils;

import java.util.Objects;

public class Game {
    private static final int MINIMUM_NUMBER_OF_CARS = 0;
    private static final int MINIMUM_NUMBER_OF_ROUNDS = 0;

    private final int numberOfCars;
    private final int numberOfRounds;
    private final Rounds rounds;

    private Game(int numberOfCars, int numberOfRounds, Rounds rounds) {
        if (numberOfCars < MINIMUM_NUMBER_OF_CARS) {
            throw new IllegalArgumentException("'numberOfCars' must be greater than or equal to " + MINIMUM_NUMBER_OF_CARS);
        }
        if (numberOfRounds < MINIMUM_NUMBER_OF_ROUNDS) {
            throw new IllegalArgumentException("'numberOfRounds' must be greater than or equal to " + MINIMUM_NUMBER_OF_ROUNDS);
        }
        AssertUtils.notNull(rounds, "'rounds' must not be null");
        this.numberOfCars = numberOfCars;
        this.numberOfRounds = numberOfRounds;
        this.rounds = rounds;
    }

    public static Game of(int numberOfCars, int numberOfRounds) {
        return new Game(
                numberOfCars,
                numberOfRounds,
                Rounds.empty()
        );
    }

    public void playOneRound(MovingStrategy movingStrategy) {
        final Round latestRound = this.load();
        final Round currentRound = this.move(latestRound, movingStrategy);
        save(currentRound);
    }

    private Round load() {
        return rounds.getLast().orElse(Round.initialRoundFrom(numberOfCars));
    }

    private Round move(Round round, MovingStrategy movingStrategy) {
        return round.move(movingStrategy);
    }

    private void save(Round round) {
        rounds.add(round);
    }

    public boolean hasFinished() {
        return rounds.size() == numberOfRounds;
    }

    public Rounds getResult() {
        return rounds;
    }

    @Override
    public String toString() {
        return "Game{" +
                "numberOfCars=" + numberOfCars +
                ", numberOfRounds=" + numberOfRounds +
                ", rounds=" + rounds +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return numberOfCars == game.numberOfCars &&
                numberOfRounds == game.numberOfRounds &&
                rounds.equals(game.rounds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfCars, numberOfRounds, rounds);
    }
}
