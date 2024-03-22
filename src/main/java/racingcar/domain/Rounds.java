package racingcar.domain;

import static racingcar.config.RacingCarException.PLAYING_COUNT_OUT_OF_RANGE;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Rounds {

    private static final int MINIMUM_PLAYING_COUNT = 1;
    private static final int START_ROUND = 1;

    private final List<Integer> rounds;

    private Rounds(final List<Integer> rounds) {
        this.rounds = rounds;
    }

    public List<Integer> rounds() {
        return this.rounds;
    }

    public static Rounds from(final int playingCount) {
        validatePlayingCountIsInRange(playingCount);

        return new Rounds(createRounds(playingCount));
    }

    private static void validatePlayingCountIsInRange(final int playingCount) {
        if (isPlayingCountLessThanMinimum(playingCount)) {
            throw new IllegalArgumentException(PLAYING_COUNT_OUT_OF_RANGE.message(playingCount));
        }
    }

    private static boolean isPlayingCountLessThanMinimum(int playingCount) {
        return playingCount < MINIMUM_PLAYING_COUNT;
    }

    private static List<Integer> createRounds(final int playingCount) {
        return IntStream.range(START_ROUND, endRound(playingCount))
                .boxed()
                .collect(Collectors.toUnmodifiableList());
    }

    private static int endRound(final int playingCount) {
        return START_ROUND + playingCount;
    }
}
