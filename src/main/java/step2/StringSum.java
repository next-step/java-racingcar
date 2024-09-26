package step2;

import java.util.ArrayList;
import java.util.Arrays;

public class StringSum {

    private String[] numberStringArray;
    private String delimiter;

    /**
     *
     * 문자열들어오면 숫자 합 반환해주는 메서드
     *
     */
    public int splictAndSum(String reqStr) {

        checkMinusAndNonNumber(reqStr);
        //null이나 빈값이면 0 반환
        if (checkNonOrNull(reqStr)) {
            return 0;
        }
        delimiter = customDelimiter(reqStr);
        //커스텀 구분자가 없으면 기본 구분자로 분리
        if ("".equals(delimiter)) {
            StringNumberToArray("[,:]",reqStr);
        }
        return addArrayData(numberStringArray);
    }
    /**
     * 구분자 기준으로 숫자들 분리
     */
    private void StringNumberToArray(String delimiter, String targetString) {
        numberStringArray = targetString.split(delimiter);
    }

    /**
     * 문자열 배열 내부 값들 합 반환
     */
    private int addArrayData(String [] Array){
        return Arrays.stream(Array).map(Integer::parseInt).mapToInt(i -> i).sum();
    }

    /**
     *  커스텀 구분자 기능
     *  문자열 앞부분의 //과 \n 사이 위치문자 찾기
     * 1. 정규표현식으로 해당 부분 찾고 가운데 반환
     * 2. //다음자리문자열 반환
     */
    private String customDelimiter (String reqStr) {
        if (reqStr.contains("//") && reqStr.contains("\\n")) {
            return reqStr.substring(2,3);
        }
        return "";
    }
    //숫자 이외값 또는 음수시 런타임에러
    private void checkMinusAndNonNumber(String reqStr) throws RuntimeException {
        if (reqStr.matches("[^0-9-]")) {
            throw new RuntimeException();
        }
    }

    //빈값이나 null 체크
    private boolean checkNonOrNull(String reqStr) throws RuntimeException {
        if("".equals(reqStr) || reqStr == null) {
            return true;
        }
    }

}
