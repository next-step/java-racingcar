package calculator;

import java.util.Arrays;
import java.util.List;

public class InputView {

    private static final String SPLIT_REGEX = " ";

    /**
     * 입력 값을 쪼개어 리스트에 담습니다.
     * @param input
     * @return
     */
    public static List<String> splitInput(String input) {
        return Arrays.asList(input.split(InputView.SPLIT_REGEX));
    }
}
