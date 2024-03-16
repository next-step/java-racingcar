package racingcar.domain;

import static java.text.MessageFormat.format;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import racingcar.vo.CarResult;
import racingcar.vo.GameResult;
import racingcar.vo.RoundResult;

public class Race {

    private static final String PLAYING_COUNT_OUT_OF_RANGE_MESSAGE = "레이싱 시도 횟수는 자연수만 가능합니다. [playingCount : {0}]";
    private static final int MINIMUM_PLAYING_COUNT = 1;

    private final RacingCars cars;
    private final CarMovement carMovement;
    private final int playingCount;

    private Race(final RacingCars racingCars, final int playingCount, final CarMovement carMovement) {
        this.cars = racingCars;
        this.playingCount = playingCount;
        this.carMovement = carMovement;
    }

    public GameResult progress() {
        return new GameResult(runAllRounds(), this.cars.winnerNames());
    }

    private List<RoundResult> runAllRounds() {
        return IntStream.rangeClosed(1, this.playingCount)
                .mapToObj(this::runSingleRound)
                .collect(Collectors.toList());
    }

    private RoundResult runSingleRound(final int round) {
        this.cars.moveForwardOrStop(this.carMovement);

        return new RoundResult(round, CarResult.fromCars(this.cars));
    }

    public static Race of(final String[] carNames, final int playingCount, final CarMovement carMovement) {
        final RacingCars racingCars = new RacingCars(carNames);
        validatePlayingCountIsInRange(playingCount);

        return new Race(racingCars, playingCount, carMovement);
    }

    private static void validatePlayingCountIsInRange(final int playingCount) {
        if (isPlayingCountOutOfRange(playingCount)) {
            throw new IllegalArgumentException(format(PLAYING_COUNT_OUT_OF_RANGE_MESSAGE, playingCount));
        }
    }

    private static boolean isPlayingCountOutOfRange(int playingCount) {
        return playingCount < MINIMUM_PLAYING_COUNT;
    }
}
