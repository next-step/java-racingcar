package step2;

import java.util.ArrayList;
import java.util.List;

public class Delimiter {

    private static final String DEFAULT_DELIMITER = ",|:";
    private final String customDelimeter;

    private Delimiter(String customDelimeter) {
        this.customDelimeter = customDelimeter;
    }

    public static Delimiter of() {
        return Delimiter.of(DEFAULT_DELIMITER);
    }

    public static Delimiter of(String customDelimeter) {
        return new Delimiter(customDelimeter);
    }

    public String[] split(String data) {
        return data.split(this.customDelimeter);
    }
}
