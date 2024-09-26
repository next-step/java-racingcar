package caculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Calculator {

    // "문자열을 분리"
    int splitString(String text) throws Exception {

        if(text == null || text.isEmpty()) {
            return emptyStringOrNull(text);
        }

        if(text.contains("-")) {
            return stringWithNegative(text);
        }

        if(text.length() == 1) {
            return oneString(text);
        }

        if(text.contains(",") && text.contains(":")) {
            return stringWithCommaAndColon(text);
        }

        if(text.contains(",")) {
            return stringWithComma(text);
        }

        return stringWithVariousSeperator(text);
    }

    // "문자열이 빈문자열 또는 null"
    int emptyStringOrNull(String text) {
        return 0;
    }

    // "문자열이 숫자 하나"
    int oneString(String text) {
        return Integer.parseInt(text);
    }

    // "콤마를 통한 문자열 분리"
    int stringWithComma(String text) {
        int sum = 0;
        String[] textSplitArr = text.split(",");

        for(String strNum : textSplitArr) {
            sum += Integer.parseInt(strNum);
        }

        return sum;
    }

    // "콤마와 콜론 구분자를 통한 문자열 분리"
    int stringWithCommaAndColon(String text) {
        int sum = 0;
        String[] textSplitArr = text.split(",|:");

        for(String strNum : textSplitArr) {
            sum += Integer.parseInt(strNum);
        }

        return sum;
    }

    // "커스텀 구분자를 통한 문자열 분리"
    int stringWithVariousSeperator(String text) { // 예시 : //;\n1;2;3
        int sum = 0;
        String[] textSplitArr = null;

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if(m.find()) {
            String customDelimiter = m.group(1); // 예시 케이스 기준 m.group(1)은 ;
            textSplitArr = m.group(2).split(customDelimiter); // 예시 케이스 기준  m.group(2)는 1;2;3
        }

        for(String strNum : textSplitArr) {
            sum += Integer.parseInt(strNum);
        }

        return sum;
    }

    // "문자열에 음수가 포함"
    int stringWithNegative(String text) throws Exception {
        throw new RuntimeException();
    }
}