package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import racingcar.utils.NumberGenerator;

public class RacingGame {

    private final int tryCountNumber;
    private final List<Round> rounds = new ArrayList<>();
    private final Cars cars;

    private static final int BEGIN_ROUND_INDEX = 0;

    public RacingGame(final List<String> carNames, final int tryCountNumber) {
        this.tryCountNumber = tryCountNumber;
        this.cars = new Cars(CarFactory.createCars(carNames));
    }

    public void play(final NumberGenerator numberGenerator) {
        IntStream.range(BEGIN_ROUND_INDEX, tryCountNumber)
            .forEach(round -> {
                rounds.add(cars.moveForwardCars(numberGenerator));
            });
    }

    public List<Round> getRounds() {
        return Collections.unmodifiableList(rounds);
    }

    public List<Car> getWinners() {
        return cars.findWinners();
    }

}
