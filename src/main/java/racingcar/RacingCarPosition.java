package racingcar;

public class RacingCarPosition {
    private static final String PROGRESS_POSITION = "-";
    private final int position;

    public RacingCarPosition(int position) {
        this.position = position;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            builder.append(PROGRESS_POSITION);
        }
        return builder.toString();
    }
}
