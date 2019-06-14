package calculator;

import java.util.regex.Pattern;

public class StringCalculator {

    public static final String REGEX_PATTERN = "^(\\d+)(?:\\s+[\\+\\-\\*\\/]+\\s+(\\d+))*$";
    private int result;

    String[] split(String input) {
        validateDelimiters(input);
        return input.split(" ");
    }

    private void validateDelimiters(String checkString){
        checkString = checkString.trim();
        Pattern pattern = Pattern.compile(REGEX_PATTERN);
        if(!pattern.matcher(checkString).find()){
            throw new IllegalArgumentException("구분자는 공백을 사용합니다.");
        }
    }

    private void validateBlank(String input) {
        if(input == null || input.trim().isEmpty()){
            throw new IllegalArgumentException("문자열을 입력하세요. ex) 4 + 2 / 3 ..");
        }
    }

    public int calculate(String input) {
        validateBlank(input);
        String[] stringArray = split(input);
        result = parseInt(stringArray[0]);
        for (int index = 1; index < stringArray.length; index++) {
            operator(stringArray, index);
        }
        return result;
    }

    private void operator(String[] strArr, int index) {
        if (index % 2 == 1) {
            Operator operator = Operator.from(strArr[index]);
            result = calculate(result, operator, parseInt(strArr[index+1]));
        }
    }

    private int parseInt(String num) {
        return Integer.parseInt(num);
    }

    int calculate(int num, Operator operator, int num2) {
        return operator.calculator(num, num2);
    }
}
