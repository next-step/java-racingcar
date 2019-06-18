package camp.nextstep.edu.racingcar.domain;

import camp.nextstep.edu.util.AssertUtils;

import java.util.Objects;

public class Game {
    private static final int MINIMUM_NUMBER_OF_ROUNDS = 0;

    private final CarNames carNames;
    private final int numberOfRounds;
    private final Rounds rounds;

    private Game(CarNames carNames, int numberOfRounds, Rounds rounds) {
        AssertUtils.notNull(carNames, "'carNames' must not be null");
        if (numberOfRounds < MINIMUM_NUMBER_OF_ROUNDS) {
            throw new IllegalArgumentException("'numberOfRounds' must be greater than or equal to " + MINIMUM_NUMBER_OF_ROUNDS);
        }
        AssertUtils.notNull(rounds, "'rounds' must not be null");

        this.carNames = carNames;
        this.numberOfRounds = numberOfRounds;
        this.rounds = rounds;
    }

    public static Game of(CarNames carNames, int numberOfRounds) {
        return new Game(
                carNames,
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
        return rounds.getLast().orElse(Round.initialRoundFrom(carNames));
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
                "carNames=" + carNames +
                ", numberOfRounds=" + numberOfRounds +
                ", rounds=" + rounds +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return numberOfRounds == game.numberOfRounds &&
                carNames.equals(game.carNames) &&
                rounds.equals(game.rounds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carNames, numberOfRounds, rounds);
    }
}
