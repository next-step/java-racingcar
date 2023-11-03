package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 문자열 안에 주어진 숫자를 더하는 연산 기능을 제공하는 유틸 클래스
 */
public class StringAdder {

    /* 커스텀 구분자로 사용할 수 있는 정규식 특수 문자 목록. 이스케이핑 처리가 필요한지 확인하기 위해 사용 */
    private static final List<Character> REGEX_SPECIAL_CHARACTER_LIST = List.of('{', '}', '[', ']', '+', '*', '.', '$', '^', '|', '?');

    /** 기본적으로 사용되는 구분자 목록 */
    private static final List<String> DEFAULT_DELIMITER_LIST = List.of(",", ":");

    /** 커스텀 구분자를 선언하는 정규식 패턴 캐싱용 변수 */
    private static final Pattern CUSTOM_DELIMITER_DECLARATION_PATTERN = Pattern.compile("//(.)\n(.*)");

    /**
     * 문자열로 정수 목록이 주어지면 정수들의 합을 계산합니다.
     * 문자열 내에서 각 정수들은 지정된 구분자로 구분되거나
     * 사용자가 직접 구분자를 정의할 수 있습니다.
     * 기본 구분자는 , 또는 :입니다.
     * 사용자가 직접 구분자를 정의하려면 //과 \n 사이에 구분자를 넣으십시오.
     *
     * @param input 구분자로 구분되는 정수들을 포함하는 문자열
     *
     * @return 해당 정수들의 합
     */
    public static int sum(String input) {
        if (input == null) {
            return 0;
        }

        if (input.isEmpty()) {
            return 0;
        }

        String customDelimiter = extractCustomDelimiter(input);
        String trimedInputString = trimCustomDelimiterDeclaration(input);

        List<String> totalDelimiterList = new ArrayList<>(DEFAULT_DELIMITER_LIST);
        if (!customDelimiter.isEmpty()) {
            totalDelimiterList.add(customDelimiter);
        }

        return getSum(convertStringListToIntList(splitIntegerListByDelimiters(trimedInputString, totalDelimiterList)));
    }

    /**
     * 주어진 정수 리스트의 합을 계산합니다.
     * @param intValueList 합을 구할 정수 배열
     * @return
     */
    private static int getSum(List<Integer> intValueList) {
        int sum = 0;
        for (int value : intValueList) {
            sum += value;
        }
        return sum;
    }

    /**
     * 내용물은 숫자이지만 타입은 문자열로 되어 있는 리스트를 실제로 정수 리스트로 변환합니다.
     *
     * @param stringValueList 내용물은 숫자이지만 타입은 문자인 리스트
     * @return 정수 리스트
     */
    private static List<Integer> convertStringListToIntList(List<String> stringValueList) {
        List<Integer> intValueList = new ArrayList<>();
        for(String stringValue : stringValueList) {
            intValueList.add(convertStringValueToIntValue(stringValue));
        }
        return intValueList;
    }

    /**
     * 문자열로 되어 있는 값을 정수형으로 바꿉니다.
     * 이 과정에서 허용되지 않는 값일 경우 예외를 던집니다.
     * 허용되는 값은 0 또는 양의 정수만입니다.
     * @param stringValue 정수형으로 바꾸려는 값
     * @return 정수형으로 바뀐 값
     */
    private static int convertStringValueToIntValue(String stringValue) {
        Integer intValue = null;
        try {
            intValue = Integer.parseInt(stringValue);
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException("허용되지 않는 값: " + stringValue);
        }

        if (intValue < 0) {
            throw new IllegalArgumentException("허용되지 않는 값: " + intValue);
        }
        return intValue;
    }

    private static List<String> splitIntegerListByDelimiters(String integerList, List<String> delimiterList) {
        String splitRegex = "";
        for (String delimiter : delimiterList) {
            splitRegex += "|" + escapingStringForRegex(delimiter);
        }
        splitRegex = splitRegex.substring(1);

        return Arrays.asList(integerList.split(splitRegex));
    }

    /**
     * 주어진 문자열에서 커스텀 구분자를 찾아 반환합니다.
     * 없다면 빈 문자열을 반환합니다.
     *
     * @param integerList 입력 문자열
     * @return 찾은 커스텀 구분자. 없다면 빈 문자열 반환. (null은 반환되지 않습니다.)
     */
    private static String extractCustomDelimiter(String integerList) {
        Matcher m = CUSTOM_DELIMITER_DECLARATION_PATTERN.matcher(integerList);
        if (m.find()) {
            return m.group(1);
        }
        return "";
    }

    /**
     * 입력 문자열에 커스텀 구분자 선언문이 있을 경우 그 부분을 잘라냅니다.
     * 없으면 입력을 그대로 반환합니다.
     * @param integerList 입력 문자열
     * @return 커스텀 구분자 선언문이 제거된 입력 문자열
     */
    private static String trimCustomDelimiterDeclaration(String integerList) {
        Matcher m = CUSTOM_DELIMITER_DECLARATION_PATTERN.matcher(integerList);
        if (m.find()) {
            return m.group(2);
        }
        return integerList;
    }

    /**
     * 주어진 문자열의 각 문자에 대해서 그것이 정규식 예약어면 앞에 역슬래시를 붙여
     * 이스케이핑 처리합니다.
     *
     * @param code 정규식에 넣으려고 하는 문자열
     * @return 이스케이핑 처리가 된 문자열
     */
    private static String escapingStringForRegex(String code) {
        StringBuilder escapedString = new StringBuilder();

        for (int p = 0; p < code.length(); p++) {
            escapedString.append(escapingCharacterForRegex(code.charAt(p)));
        }

        return escapedString.toString();
    }

    /**
     * 주어진 한 글자가 이스케이핑이 필요한 글자면 이스케이핑하여 반환합니다.
     * 아니라면 그 글자를 문자열로 변환하여 반환합니다.
     * @param code 이스케이핑 시도할 글자
     * @return 이스케이핑이 필요할 경우 이스케이핑이 된 문자열
     */
    private static String escapingCharacterForRegex(char code) {
        if (REGEX_SPECIAL_CHARACTER_LIST.contains(code)) {
            return "\\" + String.valueOf(code);
        }

        return String.valueOf(code);
    }
}
