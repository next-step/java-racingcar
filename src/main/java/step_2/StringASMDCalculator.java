package step_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static step_2.MessageConstants.*;

public class StringASMDCalculator {

    private static final String NumberFormatASMDRegexp = "[^0-9-*/+]";
    private static final String ASMDRegexp = "[-*/+]";
    private static final String BlankRegexp = "\\p{Z}";

    public static Long calculateSentence(String numberSentence) {
        verifySource(numberSentence);
        final Matcher matcher = detachOperationString(numberSentence);
        List<Integer> variablePopList = stringArrayToNumberList(splitByNumberFormat(numberSentence));
        Long destVariable = variablePopList.remove(0)
                .longValue();
        while (matcher.find() && !variablePopList.isEmpty()) {
            destVariable = OperatingMethods.valueOfCalculate(
                    matcher.group(),
                    destVariable,
                    variablePopList.remove(0));
        }
        return destVariable;
    }

    private static void verifySource(String numberSentence) {
        if (numberSentence == null || numberSentence.trim().isEmpty()) {
            IS_NULL_OR_BLANK.sendViolation();
        }
        // 아.. 이코드는 타협하고 싶은데...
        final String blackDetachSentence = numberSentence.replaceAll(BlankRegexp, "");
        final Pattern numberFormatASMDPattern = Pattern.compile(NumberFormatASMDRegexp);
        final Matcher matcher = numberFormatASMDPattern.matcher(blackDetachSentence);
        if (matcher.find()) {
            NOT_MATCH_OPERATOR.sendViolation();
        }
    }

    private static Matcher detachOperationString(String sourceString) {
        return Pattern.compile(ASMDRegexp).matcher(sourceString);
    }

    private static List<Integer> stringArrayToNumberList(String[] numberFormatArray) {
        if (Arrays.stream(numberFormatArray).anyMatch(String::isEmpty)) {
            DOES_NOT_SUPPORTED.sendViolation();
        }
        if (numberFormatArray.length <= 0) {
            return new ArrayList<>();
        }
        return Arrays.stream(numberFormatArray)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }

    private static String[] splitByNumberFormat(String sourceString) {
        return sourceString
                .replaceAll(NumberFormatASMDRegexp, "")
                .replaceAll(ASMDRegexp, "|")
                .split("\\|");
    }
}
