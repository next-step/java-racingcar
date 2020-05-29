package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Letters {
    private static final String DELIMITER = " ";
    private final String inputData;

    public Letters(String inputData) {
        this.inputData = inputData;
        checkBlank();
    }

    public List<String> splitBlank() {
        return Arrays.stream(inputData.split(DELIMITER))
                .collect(Collectors.toList());
    }

    public void checkBlank() {
        if (inputData == null || inputData.trim().isEmpty()) {
            throw new IllegalArgumentException("값을 입력해주세요.");
        }
    }
}
