import java.util.regex.Pattern;

public class Positive {

    private static final Pattern NUMERIC_REGEX = Pattern.compile("-?\\d+");

    private final String token;

    public Positive(String token) {
        this.token = token;
    }

    public Integer toInteger() {
        if (isNonNumeric()) {
            throw new RuntimeException("Non-Numeric Value");
        }
        if (isNegative()) {
            throw new RuntimeException("Negative Value");
        }

        return Integer.valueOf(this.token);
    }

    private boolean isNegative() {
        return Integer.parseInt(token) < 0;
    }

    private boolean isNonNumeric() {
        return !NUMERIC_REGEX.matcher(this.token).matches();
    }

}
