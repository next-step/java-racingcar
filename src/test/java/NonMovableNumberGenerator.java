import entity.NumberGenerator;

public class NonMovableNumberGenerator implements NumberGenerator {

    private static final int NON_MOVABLE_NUMBER = 2;

    @Override
    public int generate() {
        return NON_MOVABLE_NUMBER;
    }
}
