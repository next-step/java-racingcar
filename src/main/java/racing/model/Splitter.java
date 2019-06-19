package racing.model;

import java.util.Arrays;
import java.util.List;

public class Splitter {

    public static List<String> spiltWithComma(String value) {
        return Arrays.asList(value.split(","));
    }
}
