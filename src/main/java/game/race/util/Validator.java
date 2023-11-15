package game.race.util;

import static java.lang.Integer.parseInt;

import java.util.List;

public class Validator {

    public static void checkTryCount(String input) {
        int number;
        try {
            number = parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("0이 아닌 숫자를 입력 하세요. - " + input);
        }

        if (number == 0) {
            throw new IllegalArgumentException("0이 아닌 숫자를 입력 하세요. - " + input);
        }
    }

    public static void checkNames(List<String> names) {
        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("이름은 다섯자를 넘을 수 없습니다. - " + name);
            }
        }
    }
}
