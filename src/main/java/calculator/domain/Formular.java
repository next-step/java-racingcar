package calculator.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Formular {

    public static List<String> stringSpliter(String expressions) {
        return new ArrayList<>(Arrays.asList(expressions.split(" ")));
    }
}
