package racingcar.view;

import static racingcar.constant.Constant.COMMA;

import java.util.List;
import java.util.StringJoiner;

public class WinnerUtils {

    public static String inform(List<String> winners) {
        StringJoiner stringJoiner = new StringJoiner(COMMA);
        for (String winner : winners) {
            stringJoiner.add(winner);
        }
        return stringJoiner.toString();
    }
}
