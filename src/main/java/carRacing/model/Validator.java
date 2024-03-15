package carRacing.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    private static final Pattern NUMERIC_PATTERN = Pattern.compile("\\d");
    public static final int MIN_DISTANCE = 0;
    public static final int MAX_DISTANCE = 9;
    private static final int MAX_LENGTH = 5;

    public void nullCheck(String input) {
        if (input == null || input.isBlank()) {
            throw new RuntimeException("입력된 숫자가 없습니다.");
        }
    }

    public void numericCheck(String input) {
        Matcher matcher = NUMERIC_PATTERN.matcher(input);
        if (!matcher.find()) {
            throw new RuntimeException("숫자를 입력바랍니다.");
        }
        numberRangeCheck(input);
    }

    private void numberRangeCheck(String input) {
        Integer number = Integer.parseInt(input);
        if (number > MAX_DISTANCE || number < MIN_DISTANCE) {
            throw new RuntimeException("0-9 사이의 숫자를 입력바랍니다.");
        }
    }

    public void nameCheck(String input) {
        if(input.isBlank()){
            throw new IllegalArgumentException("입력된 자동차 이름이 없습니다.");
        }

        String[] inputNames = input.split(",");

        for (String targetName : inputNames)
            if (targetName.length() > MAX_LENGTH)
                throw new IllegalArgumentException("자동차 이름은 최대 5자리까지 입력가능합니다. " + targetName);
    }
}
