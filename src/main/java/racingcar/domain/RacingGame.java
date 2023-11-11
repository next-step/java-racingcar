package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import racingcar.utils.RandomNumberGenerator;

public class RacingGame {

    private final int truCountNumber;
    private final List<Round> rounds = new ArrayList<>();
    private final Cars cars;

    private static final int BEGIN_ROUND_INDEX = 0;

    public RacingGame(final List<String> carNames, final int tryCountNumber) {
        this.truCountNumber = tryCountNumber;
        this.cars = new Cars(CarFactory.createCars(carNames));
    }

    public void play() {
        IntStream.range(BEGIN_ROUND_INDEX, truCountNumber)
            .forEach(round -> {
                rounds.add(cars.moveForwardCars(new RandomNumberGenerator()));
            });
    }

    public List<Round> getRounds() {
        return Collections.unmodifiableList(rounds);
    }

    public List<Car> getWinners() {
        Winners winners = new Winners();
        return winners.findWinners(cars);
    }

}
