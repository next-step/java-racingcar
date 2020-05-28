package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Letters {
    private static final String DELIMITER = " ";

    public static List<String> convertStringToStrings(String inputData) {
        checkBlank(inputData);

        return Arrays.stream(inputData.split(DELIMITER))
                .collect(Collectors.toList());
    }

    static void checkBlank(String inputData) {
        if (inputData == null || inputData.trim().isEmpty()) {
            throw new IllegalArgumentException("값을 입력해주세요.");
        }
    }
}
