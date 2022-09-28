package racing.view.valid;

import java.util.Arrays;
import java.util.function.Predicate;

public class StringLengthValidator {

    private final int limit;

    public StringLengthValidator(int limit) {
        this.limit = limit;
    }

    public boolean isAllUnderLimitLength(String...strings) {
        return Arrays
                .stream(strings)
                .noneMatch(isUnderLimitLength());
    }

    private Predicate<String> isUnderLimitLength() {
        return string -> string.length() > limit;
    }
}
