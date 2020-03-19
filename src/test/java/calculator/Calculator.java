package calculator;


import org.junit.platform.commons.util.StringUtils;

public class Calculator {

    public long calculate(String input) {
        verifyInput(input);
        return 0;
    }

    private void verifyInput(String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException();
        }
    }
}
