package racinggame.ui;

public class RacingGameInputView {
    public static final int MIN_CAR_COUNT = 2;
    public static final int MIN_ROUND_COUNT = 1;

    private final MessageReader reader;
    private final MessageWriter writer;

    public RacingGameInputView(final MessageReader reader, final MessageWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public int inputRacingCarCount() {
        writer.write("자동차 대수는 몇 대 인가요?");

        final int carCount = reader.readInt();
        if (carCount < MIN_CAR_COUNT) {
            throw new IllegalArgumentException("자동차는 최소 " + MIN_CAR_COUNT + "대 이상이여야 합니다.");
        }

        return carCount;
    }

    public int inputRacingRoundCount() {
        writer.write("시도할 회수는 몇 회 인가요?");

        final int roundCount = reader.readInt();
        if (roundCount < MIN_ROUND_COUNT) {
            throw new IllegalArgumentException("시도할 회수는 최소 " + MIN_ROUND_COUNT + "회 이상이여야 합니다.");
        }

        return roundCount;
    }
}
