package calculator;

import java.util.List;

/**
 * 문자열 안에 주어진 숫자를 더하는 연산 기능을 제공하는 유틸 클래스
 */
public class StringAdder {

    /** 숫자간 구분하는 패턴입니다. */
    private static final String DELIMITER_REGEX = ",|:";

    /**
     * 문자열로 정수 목록이 주어지면 정수들의 합을 계산합니다.
     * 문자열 내에서 각 정수들은 지정된 구분자로 구분되거나
     * 사용자가 직접 구분자를 정의할 수 있습니다.
     * 기본 구분자는 , 또는 :입니다.
     * 사용자가 직접 구분자를 정의하려면 //과 \n 사이에 구분자를 넣으십시오.
     *
     * @param integerList 구분자로 구분되는 정수들을 포함하는 문자열
     *
     * @return 해당 정수들의 합
     */
    public static int sum(String integerList) {
        if (integerList == null) {
            return 0;
        }

        if (integerList.isEmpty()) {
            return 0;
        }

        if (doesContainDelimiter(integerList)) {
            return Integer.parseInt(integerList);
        }

        String[] stringValueList = integerList.split(DELIMITER_REGEX);

        int sum = 0;
        for (String stringValue : stringValueList) {
            sum += Integer.parseInt(stringValue);
        }

        return sum;
    }

    /**
     * 주어진 문자열에 구분자가 있는지 확인합니다.
     * @param integerList 구분자로 구분되는 정수를 포함하는 문자열
     * @return 구분자가 있다면 true를 반환
     */
    private static boolean doesContainDelimiter(String integerList) {
        return !integerList.contains(",") && !integerList.contains(":");
    }
}
