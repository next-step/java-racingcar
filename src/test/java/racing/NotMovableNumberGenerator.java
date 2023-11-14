package racing;

public class NotMovableNumberGenerator implements NumberGenerator{
    private static final int DEFAULT_NOT_MOVABLE_VALUE = 1;

    @Override
    public int generate() {
        return DEFAULT_NOT_MOVABLE_VALUE;
    }
}
