package calculate;

import org.apache.commons.lang3.StringUtils;

import java.util.stream.IntStream;

public class CalculateRunner {
    public static void main(String[] args) {
        String method = "2 + 3 * 4 + 6";
        System.out.println(method + " = " + new Calculator().calculate("2 + 3 * 4 + 6"));
    }
}
