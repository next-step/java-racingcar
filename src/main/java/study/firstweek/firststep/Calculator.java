package study.firstweek.firststep;

import java.util.List;
import java.util.stream.Collectors;

class Calculator {

    private final StringUtils utils = new StringUtils();

    int execute(String input) {
        if (utils.isEmpty(input)) {
            throw new IllegalArgumentException("Not valid input");
        }

        List<String> convertedChars = convertEachCharactorToStringList(input);

        if (utils.isEvenInputLength(convertedChars)) {
            throw new IllegalArgumentException("Not valid input");
        }

        return calculate(convertedChars);
    }

    private int calculate(List<String> inputList) {
        int value = Integer.parseInt(inputList.get(0));
        for (int i = 1; i < inputList.size(); i += 2) {
            value = OperationMethod.of(inputList.get(i)).calculate(value, Integer.parseInt(inputList.get(i + 1)));
        }
        return value;
    }

    private List<String> convertEachCharactorToStringList(String input) {
        return input.chars()
            .mapToObj(i -> String.valueOf((char) i))
            .filter(i -> utils.isNotEmpty(i))
            .collect(Collectors.toList());
    }
}
