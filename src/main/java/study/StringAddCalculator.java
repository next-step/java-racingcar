package study;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StringAddCalculator {
    private final String[] defaultSeparators = new String[] { ",", ":" };

    int sumBySeparator(String input) {
        if (input == null) {
            return 0;
        }
        String[] inputSeparators = this.parseSeparatorDefinition(input);
        Set<String> separators = this.mergeSeparators(inputSeparators);
        String inputExcludeSeparatorDefinition = input;
        if (inputSeparators.length > 0) {
            inputExcludeSeparatorDefinition = this.removeSeparatorDefinition(input);
        }
        if(inputExcludeSeparatorDefinition.length() < 1) {
            return 0;
        }

        String[] splitInputs = this.splitBySeparators(inputExcludeSeparatorDefinition, separators);
        List<Integer> integerList;
        try {
            integerList = this.stringArrayToIntegerList(splitInputs);
        } catch(Exception e) {
//            e.printStackTrace();
            throw new RuntimeException("숫자가 아닌값은 더할수 없습니다.");
        }
        boolean existNegative = this.existNegativeInteger(integerList);
        if (existNegative) {
            throw new RuntimeException("음수는 더할수 없습니다.");
        }
        return this.sum(integerList);
    }

    private String[] parseSeparatorDefinition(String input) {
        int[] location;
        try {
            location = this.findSeparatorDefinitionLocation(input);
        } catch(Exception e) {
//            e.printStackTrace();
            String[] emptyArr = {};
            return emptyArr;
        }
        int startIndex = location[0] + 2;
        int endIndex = location[1];
        String separatorString = input.substring(startIndex, endIndex);
        return separatorString.split("");
    }

    private int[] findSeparatorDefinitionLocation(String input) {
        int startIndex = input.indexOf("//");
        int endIndex = input.indexOf("\n");
        if (startIndex == -1 || endIndex == -1) {
            throw new RuntimeException("구분자정의를 찾지 못하였습니다.");
        }
        int[] result = { startIndex, endIndex };
        return result;
    }

    private Set<String> mergeSeparators(String[] inputSeparators) {
        Set<String>  separators = new HashSet<>();
        for (int i = 0; i < inputSeparators.length; i++) {
            separators.add(inputSeparators[i]);
        }
        for (int i = 0; i < this.defaultSeparators.length; i++) {
            separators.add(this.defaultSeparators[i]);
        }
        return separators;
    }

    private String removeSeparatorDefinition(String input) {
        int[] separationDefinitionLocation = this.findSeparatorDefinitionLocation(input);
        int startIndex = separationDefinitionLocation[1] + 1;
        return input.substring(startIndex);
    }

    private String[] splitBySeparators(String inputExcludeSeparatorDefinition, Set<String> separators) {
        String splitRegex =  "[" + String.join("", separators) + "]";
        return inputExcludeSeparatorDefinition.split(splitRegex);
    }

    private List<Integer> stringArrayToIntegerList(String[] splitInputs) {
        return Arrays.stream(splitInputs)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private boolean existNegativeInteger(List<Integer> integerList) {
        return integerList.stream().anyMatch(integer -> integer < 0);

    }

    private int sum(List<Integer> inputs) {
        return inputs.stream().mapToInt(Integer::intValue).sum();
    }

}


