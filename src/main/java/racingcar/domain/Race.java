package racingcar.domain;

import static java.text.MessageFormat.format;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import racingcar.util.NumberGenerator;
import racingcar.vo.CarResult;
import racingcar.vo.GameResult;
import racingcar.vo.RoundResult;

public class Race {

    private static final String INVALID_CAR_COUNT_MESSAGE = "자동차의 대수는 자연수만 가능합니다. [carCount : {0}]";
    private static final String INVALID_PLAYING_COUNT_MESSAGE = "레이싱 시도 횟수는 자연수만 가능합니다. [playingCount : {0}]";
    private static final int ZERO = 0;

    private final List<Car> cars;
    private final int playingCount;
    private final List<RoundResult> roundResults;
    private final NumberGenerator numberGenerator;

    private Race(final List<Car> cars, final int playingCount, final NumberGenerator numberGenerator) {
        this.cars = cars;
        this.playingCount = playingCount;
        this.roundResults = new ArrayList<>();
        this.numberGenerator = numberGenerator;
    }

    public void run() {
        for (int round = 1; round <= this.playingCount; round++) {
            moveCars();

            final RoundResult roundResult = RoundResult.of(round, CarResult.fromCars(this.cars));
            this.roundResults.add(roundResult);
        }
    }

    private void moveCars() {
        this.cars.forEach(car -> {
            final int movingCondition = numberGenerator.generate();
            car.moveForwardOrStop(movingCondition);
        });
    }

    public GameResult result() {
        return GameResult.from(this.roundResults);
    }

    public static Race of(final int carCount, final int playingCount, final NumberGenerator numberGenerator) {
        validateCarCountIsPositive(carCount);
        validatePlayingCountIsPositive(playingCount);

        final List<Car> cars = IntStream.range(1, carCount + 1)
                .mapToObj(Car::new)
                .collect(Collectors.toList());

        return new Race(cars, playingCount, numberGenerator);
    }

    private static void validateCarCountIsPositive(final int carCount) {
        if (carCount <= ZERO) {
            throw new IllegalArgumentException(format(INVALID_CAR_COUNT_MESSAGE, carCount));
        }
    }

    private static void validatePlayingCountIsPositive(final int playingCount) {
        if (playingCount <= ZERO) {
            throw new IllegalArgumentException(format(INVALID_PLAYING_COUNT_MESSAGE, playingCount));
        }
    }
}
