package calculator.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExpressionUtil {

    private ExpressionUtil() {
    }

    public static List<String> split(String expression) {
        return new ArrayList<>(Arrays.asList(expression.split(" ")));
    }
}
