package step2;

public class PositiveInteger {

    public static final PositiveInteger ZERO = new PositiveInteger(0);

    private final int num;

    public PositiveInteger(int num) {
        if (num < 0) {
            throw new IllegalArgumentException(ErrorMessage.NEGATIVE_NOT_SUPPORTED.toString());
        }
        this.num = num;
    }

    public int getIntValue() {
        return this.num;
    }

    public static PositiveInteger sum(PositiveInteger a, PositiveInteger b) {
        return new PositiveInteger(a.num + b.num);
    }

}
