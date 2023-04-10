import java.util.regex.Matcher;
import static java.util.regex.Pattern.*;

public class StringAddCalculator {

    static final String containZeroToNine = "[0-9]";
    static int sumValue = 0;

    public static int splitAndSumNullOrEmpty(String stringParameter) {
        if (stringParameter == null) { stringParameter = "0"; }
        if (stringParameter.isEmpty()) { stringParameter = "0"; }

        int returnValue = Integer.parseInt(stringParameter);

        return returnValue;
    }

    public static int splitAndSumOneNumber(String stringParameter) {
        int returnValue = Integer.parseInt(stringParameter);

        return returnValue;
    }

    public static int splitAndSum(String stringParameter) {

        String[] splitStringParameter = stringParameter.split(",");

        for (int i=0; i < splitStringParameter.length; i++) {
            sumValue = Integer.parseInt(splitStringParameter[i]) + sumValue;
        }

        return sumValue;
    }

    public static int splitAndSumTwoRegex(String stringParameter) {

        String[] splitStringParameter = stringParameter.split(",|:");

        for (int i=0; i < splitStringParameter.length; i++) {
            sumValue = Integer.parseInt(splitStringParameter[i]) + sumValue;
        }

        return sumValue;
    }

    public static int splitAndSumCustom(String stringParameter) {

        Matcher m = compile("//(.)\n(.*)").matcher(stringParameter);

        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens = m.group(2).split(customDelimiter);

            for (int i = 0; i < tokens.length; i++) {
                if (!(tokens[i].trim().matches("[0-9]"))) {
                    throw new RuntimeException();
                }
                sumValue = Integer.parseInt(tokens[i].trim()) + sumValue;
            }
        }

        return sumValue;

    }

    public static int splitAndSumNotNumber(String stringParameter) {

        String[] splitStringParameter = stringParameter.split(",");

        if (splitStringParameter.length == 1) {
            if (!(splitStringParameter[0].trim().matches(containZeroToNine))) {
                throw new RuntimeException("숫자 이외의 값이 포함되어 있습니다!");
            }
            return Integer.parseInt(splitStringParameter[0]);
        }

        for (String s : splitStringParameter) {
            if (!(s.trim().matches(containZeroToNine))) {
                throw new RuntimeException("숫자 이외의 값이 포함되어 있습니다!");
            }
            sumValue = Integer.parseInt(s.trim()) + sumValue;
        }

        return sumValue;
    }

}
