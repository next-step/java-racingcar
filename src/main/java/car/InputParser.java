package car;

import java.util.List;

public class InputParser {

    private static final String DELIMITER = ",";
    private static final int LIMIT_LENGTH = 5;

    public List<String> parseUserInputByDelimiter(String userInput) {
        List<String> carNames = List.of(userInput.split(DELIMITER));
        validateCarNames(carNames);
        return carNames;
    }

    private void validateCarNames(List<String> carNames) {
        for (String carName : carNames) {
            checkMoreThanLimitLength(carName);
        }
    }

    private static void checkMoreThanLimitLength(String carName) {
        if(carName.length() > LIMIT_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5글자를 초과해서는 안됩니다");
        }
    }
}
