package racingcar;

import java.util.stream.IntStream;

public class RacingCarPosition {
    private static final String PROGRESS_POSITION = "-";
    private final int position;

    public RacingCarPosition(int position) {
        this.position = position;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        IntStream.range(Const.INITIAL_NUM, position)
                .forEach(position -> builder.append(PROGRESS_POSITION));
        return builder.toString();
    }
}
