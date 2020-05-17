package caculator;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

public class InputProcessor {
    private static final String SPLIT_TOKEN = " ";

    public String[] processInput(final String input) {
        validateNullOrEmpty(input);

        String[] splitInput = input.split(SPLIT_TOKEN);
        validateNumber(splitInput);
        validateOperator(splitInput);
        return splitInput;
    }

    private void validateNullOrEmpty(final String input) {
        if (StringUtils.isBlank(input)) throw new IllegalArgumentException();
    }

    private void validateNumber(final String[] splitInput) {
        for(int i = 0; i < splitInput.length; i += 2) {
            if (Double.isNaN(Double.parseDouble(splitInput[i]))) throw new IllegalArgumentException();
        }
    }

    private void validateOperator(final String[] splitInput) {
        List<String> operatorList = Arrays.asList("+", "-", "*", "/");
        for(int i = 1; i < splitInput.length; i += 2) {
            if (!operatorList.contains(splitInput[i])) throw new IllegalArgumentException();
        }
    }
}
