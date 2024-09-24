package step2;

import java.util.ArrayList;
import java.util.Arrays;

public class StringSum {

    private String[] numberStringArray;

    /**
     * 구분자 기준으로 숫자들 분리
     */
    public void StringNumberToArray(String delimiter, String targetString) {
        numberStringArray = targetString.split(delimiter);
    }

    /**
     * 문자열 배열 내부 값들 합 반환
     */
    public int addArrayData(String [] Array){
        int sum= Arrays.stream(Array).map(Integer::parseInt).mapToInt(i -> i).sum();
        return sum;
    }

}
