package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Calculator {

    public static int splitAndSum(String text) {
        String delimiter = "[,|:]";
        if (Objects.isNull(text) || text.isEmpty()) {
            return 0;
        }
        String[] strings = text.split(delimiter);
        int result = 0;
        for (String string : strings) {
            System.out.println("string = " + string);
            result += Integer.parseInt(string);
        }
        return result;
    }
}
