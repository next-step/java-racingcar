package racingcar.view;

import calculator.StringParser;

public class ToStringsParser implements StringParser<String> {
    private static final String DELIMITER = ",";

    @Override
    public String[] parse(String input) {
        return input.split(DELIMITER);
    }
}
