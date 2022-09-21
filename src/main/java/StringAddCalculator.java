import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String CUSTOM_DELIMITER = "//(.)\\n(.*)";
    private static final String CUSTOM_SPLIT_DELIMITER = ",|:";
    private static final String JOIN_DELIMITER = ",";


    public static int splitAndSum(String inputCase) {

        int result = 0;

        // 입력된 문자열이 null 혹은 공백일 경우 0 반환
        if (checkNullAndBlank(inputCase)) {
            return result;
        }
        // 정규표현식을 거친 문자열 배열을 반환
        String[] regexArr = applyCustomRegexAndConvertToStringArr(inputCase);

        // 문자열 배열을 숫자 배열로 반환
        List<Integer> intArr = convertStringArrToIntArr(regexArr);

        // 배열을 덧셈
        result = sumAllElements(intArr);

        return result;
    }

    /**
     * null 과 공백값이 들어왔는지 확인하는 메소드
     * @param inputCase
     * @return
     */
    private static boolean checkNullAndBlank(String inputCase) {
        return ((inputCase == null) || (inputCase.isEmpty()));
    }

    /**
     * 정규표현식을 적용하여 문자열 배열을 반환하는 메소드
     * @param inputCase
     * @return
     */
    private static String[] applyCustomRegexAndConvertToStringArr(String inputCase) {

        // 기본 구분자 설정
        Matcher m = Pattern.compile(CUSTOM_DELIMITER).matcher(inputCase);

        String regexString = inputCase;
        
        if (m.find()) {
            // 커스텀 구분자를 설정
            String customDelimiter = m.group(1);
            // 정규화된 문자열 배열
            String[] regexArr = m.group(2).split(customDelimiter);
            // 배열을 문자열로 치환
            regexString = String.join(JOIN_DELIMITER, regexArr);
        }
        // 두번째 정규표현식을 적용함
        return regexString.split(CUSTOM_SPLIT_DELIMITER);
    }


    /**
     * 문자열 배열을 숫자배열로 치환 하는 메소드
     * @param inputCase
     * @return
     */
    private static List<Integer> convertStringArrToIntArr(String[] inputCase) {

        List<Integer> intArr = new ArrayList<>();

        for (String stringNumber : inputCase) {
            // 문자열을 숫자로 반환
            int stringToInt = convertStringToInteger(stringNumber);
            // 변환된 숫자가 음수인지 확인
            checkNegativeInt(stringToInt);
            intArr.add(stringToInt);
        }
        return intArr;
    }

    /**
     * 문자를 숫자로 변환하는 메소드
     * @param inputCase
     * @return
     */
    private static int convertStringToInteger(String inputCase) {
        return Integer.parseInt(inputCase);
    }

    /**
     * 음수값인지 확인하는 메소드
     * @param isNegative
     */
    private static void checkNegativeInt(int isNegative) {
        if (isNegative < 0) {
            throw new NegativeNumberException("음수값입니다");
        }
    }

    /**
     * 배열의 모든 숫자값을 더하는 메소드
     * @param inputCase
     * @return
     */
    private static int sumAllElements(List<Integer> inputCase) {
        return inputCase.stream().mapToInt(it -> it).sum();
    }
}
