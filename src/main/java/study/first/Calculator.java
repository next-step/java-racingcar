package study.first;

import static study.first.StringUtils.isEmpty;
import static study.first.StringUtils.isEvenInputLength;
import static study.first.StringUtils.isNotEmpty;

import java.util.List;
import java.util.stream.Collectors;

class Calculator {

    int execute(String input) {
        if (isEmpty(input)) {
            throw new IllegalArgumentException("Not valid input");
        }

        List<String> convertedList = convertEachCharactorToStringList(input);

        if (isEvenInputLength(convertedList.size())) {
            throw new IllegalArgumentException("Not valid input");
        }

        return calculate(convertedList);
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
            .filter(i -> isNotEmpty(i))
            .collect(Collectors.toList());
    }

}
