package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    public static final String REGEX = ",|:";

    public int calculate(String text) throws Exception {
        return addNumbers(
                stringArrToIntArr(
                        splitText(text)
                )
        );
    }

    private int addNumbers(int[] numbers) {
        int sum = 0;
        for(int num : numbers) {
            sum += num;
        }
        return sum;
    }

    private int[] stringArrToIntArr(String[] textSplitArr) throws Exception {
        int[] numbers = new int[textSplitArr.length];

        for(int i = 0; i < textSplitArr.length; i++) {
            int num = Integer.parseInt(textSplitArr[i]);
            validatePositive(num);
            numbers[i] = num;
        }

        return numbers;
    }

    private String[] splitText(String text) throws Exception {

        if(text == null || text.isEmpty()) {
            return textIsEmptyStringOrNull(text);
        }

        if(text.length() == 1) {
            return textIsOneSizeString(text);
        }

        if(text.contains(",") && text.contains(":")) {
            return textWithCommaAndColon(text);
        }

        if(text.contains(",")) {
            return textWithComma(text);
        }

        return textWithVariousSeperator(text);
    }

    // "문자열이 빈문자열 또는 null"
    private String[] textIsEmptyStringOrNull(String text) {
        String[] textSplitArr = new String[1];
        textSplitArr[0] = "0";
        return textSplitArr;
    }

    // "문자열이 숫자 하나"
    private String[] textIsOneSizeString(String text) {
        String[] textSplitArr = new String[1];
        textSplitArr[0] = text;
        return textSplitArr;
    }

    // "콤마를 통한 문자열 분리"
    private String[] textWithComma(String text) {
        return text.split(",");
    }

    // "콤마와 콜론 구분자를 통한 문자열 분리"
    private String[] textWithCommaAndColon(String text) {
        return text.split(REGEX);
    }

    // "커스텀 구분자를 통한 문자열 분리"
    private String[] textWithVariousSeperator(String text) { // 예시 : //;\n1;2;3

        String[] textSplitArr = null;

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if(m.find()) {
            String customDelimiter = m.group(1); // 예시 케이스 기준 m.group(1)은 ;
            textSplitArr = m.group(2).split(customDelimiter); // 예시 케이스 기준  m.group(2)는 1;2;3
        }
        return textSplitArr;
    }

    // "배열에 음수가 포함"
    private void validatePositive(int num) throws Exception {
        if (num < 0) {
            throw new RuntimeException("음수가 포함되어 있습니다.");
        }
    }
}