package racingcarver2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputStringValidator {

    private static final Pattern onlyNumberPattern = Pattern.compile("^[0-9]*?");
    private static final String ERROR_MESSAGE = "잘못된 입력값 입니다";

    public static int valid(String input) {
        Matcher matcher = onlyNumberPattern.matcher(input);

        if(matcher.find()) {
            return checkPositive(input);
        }

        System.out.println(ERROR_MESSAGE);

        //TODO: 수정 필요
        throw new RuntimeException();
    }

    private static int checkPositive(String input) {
        int number = Integer.parseInt(input);

        if(number < 0) {
            //TODO: 수정 필요
            throw new RuntimeException();
        }

        return number;

    }
}
