package step_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringASMDCalculator {

    public static Long calculateSentence(String numberSentence) {
        verifySource(numberSentence);
        final Matcher matcher = detachOperationString(numberSentence);
        List<Integer> variablePopList = stringArrayToNumberList(splitByNumberFormat(numberSentence));
        Long destVariable = variablePopList.remove(0).longValue();
        while (matcher.find() && !variablePopList.isEmpty()) {
            destVariable = calculate(OperatingMethods.valueOfString(matcher.group()).orElseThrow(NoSuchElementException::new), destVariable, variablePopList.remove(0));
        }
        return destVariable;
    }

    private static void verifySource(String numberSentence) {
        if (numberSentence == null || numberSentence.trim().isEmpty()) MessageConstants.IS_NULL_OR_BLANK.sendViolation();
        if (Pattern.compile("[^0-9-*/+]").matcher(numberSentence.replaceAll("\\p{Z}", "")).find()) MessageConstants.NOT_MATCH_OPERATOR.sendViolation();
    }

    private static Matcher detachOperationString(String sourceString) {
        return Pattern.compile("[-*/+]").matcher(sourceString);
    }

    private static List<Integer> stringArrayToNumberList(String[] numberFormatArray) {
        if (Arrays.stream(numberFormatArray).anyMatch(String::isEmpty)) MessageConstants.DOES_NOT_SUPPORTED.sendViolation();
        if (numberFormatArray.length <= 0) return new ArrayList<>();
        return Arrays.stream(numberFormatArray).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
    }

    private static Long calculate(OperatingMethods operator, Long currentValue, Integer nextValue) {
        if (currentValue == null) return nextValue.longValue();
        switch (operator) {
            case ADD: return add(currentValue.intValue(), nextValue);
            case SUB: return sub(currentValue.intValue(), nextValue);
            case DIV: return division(currentValue.intValue(), nextValue);
            default: return multiply(currentValue.intValue(), nextValue);
        }
    }

    private static String[] splitByNumberFormat(String sourceString) {
        return sourceString.replaceAll("[^0-9-*/+]", "").replaceAll("[-*/+]", "|").split("\\|");
    }

    private static Long add(Integer primaryVariable, Integer secondaryVariable) {
        return (long) Integer.sum(primaryVariable, secondaryVariable);
    }

    private static Long sub(Integer primaryVariable, Integer secondaryVariable) {
        return (long) Integer.sum(primaryVariable, -secondaryVariable);
    }

    private static Long multiply(Integer primaryVariable, Integer secondaryVariable) {
        primaryVariable *= secondaryVariable;
        return (long) primaryVariable;
    }

    private static Long division(Integer primaryVariable, Integer secondaryVariable) {
        if (secondaryVariable == 0) MessageConstants.DIVIDE_BY_ZERO.sendViolation();
        return (long) primaryVariable / secondaryVariable;
    }

}
