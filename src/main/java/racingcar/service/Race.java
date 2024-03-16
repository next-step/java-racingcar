package racingcar.service;

import static java.text.MessageFormat.format;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import racingcar.domain.Cars;
import racingcar.domain.MovementStrategy;
import racingcar.vo.CarResult;
import racingcar.vo.GameResult;
import racingcar.vo.RoundResult;

public class Race {

    private static final String PLAYING_COUNT_OUT_OF_RANGE_MESSAGE = "레이싱 시도 횟수는 자연수만 가능합니다. [playingCount : {0}]";
    private static final int MINIMUM_PLAYING_COUNT = 1;
    private static final int START_ROUND = 1;

    private final Cars cars;
    private final MovementStrategy movementStrategy;

    private Race(final Cars racingCars, final MovementStrategy movementStrategy) {
        this.cars = racingCars;
        this.movementStrategy = movementStrategy;
    }

    public GameResult progress(final int playingCount) {
        validatePlayingCountIsInRange(playingCount);

        return new GameResult(runAllRounds(playingCount), this.cars.winnerNames());
    }

    private static void validatePlayingCountIsInRange(final int playingCount) {
        if (isPlayingCountOutOfRange(playingCount)) {
            throw new IllegalArgumentException(format(PLAYING_COUNT_OUT_OF_RANGE_MESSAGE, playingCount));
        }
    }

    private static boolean isPlayingCountOutOfRange(int playingCount) {
        return playingCount < MINIMUM_PLAYING_COUNT;
    }

    private List<RoundResult> runAllRounds(final int playingCount) {
        return IntStream.rangeClosed(START_ROUND, endRound(playingCount))
                .mapToObj(this::runSingleRound)
                .collect(Collectors.toList());
    }

    private int endRound(final int playingCount) {
        return START_ROUND + playingCount;
    }

    private RoundResult runSingleRound(final int round) {
        this.cars.moveForwardOrStop(this.movementStrategy);

        return new RoundResult(round, CarResult.fromCars(this.cars));
    }

    public static Race of(final String[] carNames, final MovementStrategy movementStrategy) {
        return new Race(Cars.from(carNames), movementStrategy);
    }
}
