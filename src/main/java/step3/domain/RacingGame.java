package step3.domain;

import step3.utils.NumberGenerator;
import step3.utils.RandomNumberGenerator;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingGame {

    private int racingCarNumber;
    private int tryCountNumber;
    private List<Round> rounds;
    private Cars cars;

    public RacingGame(final int racingCarNumber, final int tryCountNumber) {
        this.racingCarNumber = racingCarNumber;
        this.tryCountNumber = tryCountNumber;
        this.cars = new Cars(CarFactory.createCars(racingCarNumber));
        this.rounds = createRounds(tryCountNumber);
    }

    public void play() {
        rounds.stream().forEach(round -> {
            round.playRound(cars);
            cars = round.getRoundCarStatus().copyCars();
        });
    }

    public List<Round> getRounds() {
        return Collections.unmodifiableList(rounds);
    }

    private List<Round> createRounds(final int tryCountNumber) {
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        return Stream.generate(() -> new Round(cars, numberGenerator))
                .limit(tryCountNumber)
                .collect(Collectors.toList());
    }

}
