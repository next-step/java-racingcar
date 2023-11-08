package racingcar.domain;

import racingcar.utils.NumberGenerator;
import racingcar.utils.RandomNumberGenerator;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingGame {

    private List<Round> rounds;
    private Cars cars;

    public RacingGame(final List<String> carNames, final int tryCountNumber) {
        this.cars = new Cars(CarFactory.createCars(carNames));
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
