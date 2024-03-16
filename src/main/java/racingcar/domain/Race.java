package racingcar.domain;

import static java.text.MessageFormat.format;

import java.util.List;

import racingcar.domain.movement.BasicMovingStrategy;
import racingcar.domain.movement.RandomNumberGenerator;
import racingcar.vo.CarResult;
import racingcar.vo.GameResult;
import racingcar.vo.RoundResult;

public class Race {

    private static final String PLAYING_COUNT_OUT_OF_RANGE_MESSAGE = "레이싱 시도 횟수는 자연수만 가능합니다. [playingCount : {0}]";
    private static final int MINIMUM_PLAYING_COUNT = 1;

    private final RacingCars cars;
    private final int playingCount;
    private final GameResult result;

    public Race(final String[] carNames, final int playingCount) {
        this.cars = new RacingCars(carNames);

        validatePlayingCountIsInRange(playingCount);
        this.playingCount = playingCount;

        this.result = new GameResult();
    }

    private static void validatePlayingCountIsInRange(final int playingCount) {
        if (isPlayingCountOutOfRange(playingCount)) {
            throw new IllegalArgumentException(format(PLAYING_COUNT_OUT_OF_RANGE_MESSAGE, playingCount));
        }
    }

    private static boolean isPlayingCountOutOfRange(int playingCount) {
        return playingCount < MINIMUM_PLAYING_COUNT;
    }

    public GameResult progress() {
        final CarMovement carMovement = setCarMovementOption();

        for (int round = 1; round <= this.playingCount; round++) {
            cars.moveForwardOrStop(carMovement);
            addRoundResult(round);
        }

        final List<String> winnerNames = this.cars.winnerNames();
        this.result.updateWinnerNames(winnerNames);

        return this.result;
    }

    private CarMovement setCarMovementOption() {
        return new CarMovement(new BasicMovingStrategy(), new RandomNumberGenerator());
    }

    private void addRoundResult(final int round) {
        final RoundResult roundResult = new RoundResult(round, CarResult.fromCars(this.cars));
        this.result.addRoundResult(roundResult);
    }
}
