package nextstep;

public class NonNegativeInteger {
    public static final NonNegativeInteger ZERO = new NonNegativeInteger(0);
    private final int number;

    public NonNegativeInteger(String token) {
        int integer = tokenToInteger(token);
        validateNonNegativeInteger(integer);
        this.number = integer;
    }

    public NonNegativeInteger(int number) {
        validateNonNegativeInteger(number);
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

    private static int tokenToInteger(String token) {
        try {
            return Integer.parseInt(token);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format("Token is not a valid integer value: %s", token));
        }
    }

    private static void validateNonNegativeInteger(int integer) {
        if (integer < 0) {
            throw new IllegalArgumentException(String.format("Negative integer values are not allowed: %s", integer));
        }
    }

    public static NonNegativeInteger sum(NonNegativeInteger x, NonNegativeInteger y) {
        return new NonNegativeInteger(x.number + y.number);
    }
}
