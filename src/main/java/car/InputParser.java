package car;

import java.util.List;

public class InputParser {

    private static final String DELIMITER = ",";

    public List<String> parseUserInputByDelimiter(String userInput) {
        return List.of(userInput.split(DELIMITER));
    }
}
