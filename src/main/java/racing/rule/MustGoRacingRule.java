package racing.rule;

public class MustGoRacingRule implements RacingRule{

    public static final int DEFAULT_START_BOUND_NUMBER = 4;

    @Override
    public int generateNumber() {
        return DEFAULT_START_BOUND_NUMBER;
    }
}
