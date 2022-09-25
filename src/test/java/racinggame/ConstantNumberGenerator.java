package racinggame;

public class ConstantNumberGenerator implements NumberGenerator {

    private final int constantNumber;

    public ConstantNumberGenerator(int constantNumber) {
        this.constantNumber = constantNumber;
    }

    @Override
    public int generateNumber() {
        return constantNumber;
    }

}
