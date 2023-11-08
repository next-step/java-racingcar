package racingcar.domain;

import java.util.Collections;
import racingcar.utils.NumberGenerator;
import racingcar.utils.RandomNumberGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingGame {

    private List<Round> rounds;
    private Cars cars;

    public RacingGame(final List<String> carNames, final int tryCountNumber) {
        this.cars = new Cars(CarFactory.createCars(carNames));
        this.rounds = createRounds(tryCountNumber, new RandomNumberGenerator());
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

    public String getWinners() {
        return cars.getCars().stream()
            .filter(car -> car.getCarPosition() == getMaxPosition())
            .map(Car::getCarName)
            .collect(Collectors.joining(","));
    }

    private List<Round> createRounds(final int tryCountNumber,
        final NumberGenerator numberGenerator) {
        return Stream.generate(() -> new Round(cars, numberGenerator))
            .limit(tryCountNumber)
            .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.getCars().stream()
            .mapToInt(car -> car.getCarPosition())
            .max()
            .orElseThrow(() -> new IllegalArgumentException("자동차가 존재하지 않습니다."));
    }

}
