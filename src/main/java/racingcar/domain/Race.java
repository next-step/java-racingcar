package racingcar.domain;

import static java.text.MessageFormat.format;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import racingcar.domain.movement.BasicMovingStrategy;
import racingcar.domain.movement.RandomNumberGenerator;
import racingcar.vo.CarResult;
import racingcar.vo.GameResult;
import racingcar.vo.RoundResult;

public class Race {

    private static final String DUPLICATED_CAR_NAME_MESSAGE = "자동차 이름은 중복될 수 없습니다. [carNames: {0}]";
    private static final String CAR_COUNT_OUT_OF_RANGE_MESSAGE = "자동차의 대수는 자연수만 가능합니다. [carCount : {0}]";
    private static final String PLAYING_COUNT_OUT_OF_RANGE_MESSAGE = "레이싱 시도 횟수는 자연수만 가능합니다. [playingCount : {0}]";
    private static final int MINIMUM_COUNT = 0;

    private final List<Car> cars;
    private final int playingCount;
    private final List<RoundResult> roundResults;

    public Race(final int carCount, final int playingCount) {
        validateCarCountIsInRange(carCount);
        validatePlayingCountIsInRange(playingCount);

        this.cars = readyCars(carCount);
        this.playingCount = playingCount;
        this.roundResults = new ArrayList<>();
    }

    public Race(final String[] carNames, final int playingCount) {
        validateCarNamesAreNotDuplicated(carNames);
        validatePlayingCountIsInRange(playingCount);

        this.cars = readyCars(carNames);
        this.playingCount = playingCount;
        this.roundResults = new ArrayList<>();
    }

    private static List<Car> readyCars(final int carCount) {
        return IntStream.range(1, carCount + 1)
                .mapToObj(Car::new)
                .collect(Collectors.toList());
    }

    private static void validateCarCountIsInRange(final int carCount) {
        if (carCount <= MINIMUM_COUNT) {
            throw new IllegalArgumentException(format(CAR_COUNT_OUT_OF_RANGE_MESSAGE, carCount));
        }
    }

    private static List<Car> readyCars(final String[] carNames) {
        return Arrays.stream(carNames)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private void validateCarNamesAreNotDuplicated(String[] carNames) {
        final long carCount = Arrays.stream(carNames)
                .distinct()
                .count();

        if (carNames.length != carCount) {
            throw new IllegalArgumentException(format(DUPLICATED_CAR_NAME_MESSAGE, Arrays.toString(carNames)));
        }
    }

    private static void validatePlayingCountIsInRange(final int playingCount) {
        if (playingCount <= MINIMUM_COUNT) {
            throw new IllegalArgumentException(format(PLAYING_COUNT_OUT_OF_RANGE_MESSAGE, playingCount));
        }
    }

    public void run() {
        final CarMovement carMovement = new CarMovement(new BasicMovingStrategy(), new RandomNumberGenerator());

        for (int round = 1; round <= this.playingCount; round++) {
            moveCars(carMovement);

            final RoundResult roundResult = RoundResult.of(round, CarResult.fromCars(this.cars));
            this.roundResults.add(roundResult);
        }
    }

    private void moveCars(final CarMovement carMovement) {
        this.cars.forEach(car -> car.moveForwardOrStop(carMovement));
    }

    public GameResult result() {
        return GameResult.from(this.roundResults);
    }
}
