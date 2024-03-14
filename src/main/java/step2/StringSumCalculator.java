package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSumCalculator {

    public int calculateStringWithSumOnly(String input){

        if(input.isEmpty())
            return 0;

        if(hasCustomDelimiter(input)){
            String customDelimiter = getCustomDelimiter(input);
            String stringExpression = getStringWithoutCustomDelimiter(input);
            String[] stringArray = splitValuesByCustomDelimiter(customDelimiter, stringExpression);
            return sum(stringArray);
        }

        String[] stringArray = splitWithCommaAndColon(input);
        return sum(stringArray);
    }


    private String[] splitWithCommaAndColon(String value) {
        return value.split("[,|:]");
    }

    private int sum(String[] valueArray) {
        int result = 0;
        for (String value : valueArray) {
            checkInputAvailable(value);
            result += Integer.parseInt(value);
        }
        return result;
    }

    private String getCustomDelimiter(String value) {
        Pattern pattern = Pattern.compile("//(.)\\n*");
        Matcher matcher = pattern.matcher(value);
        if (matcher.find()) {
            System.out.println("==============");
            System.out.println(matcher.group(1));
            return matcher.group(1);
        }
        return null;
    }

    private void checkInputAvailable(String value) {
        if (!value.matches("\\d+")) {
            throw new RuntimeException();
        }
    }

    private Boolean hasCustomDelimiter(String value) {
        return !Character.isDigit(value.charAt(0));
    }

    private String getStringWithoutCustomDelimiter(String value) {
        return value.substring(5);
    }

    private String[] splitValuesByCustomDelimiter(String delimiter,
                                                  String value) {
        return value.split(delimiter);
    }
}
