package step1;

import org.apache.commons.lang3.ObjectUtils;

import java.util.*;

/**
 * 유효성 검사를 하는 클래스
 */

public class ValidationCheck {
    ArrayList<String> operatorList = new ArrayList<>();
    // 1. null Check
    public void nullCheck(String str) {

        if(ObjectUtils.equals(str, null) || str.isEmpty()){
            throw new IllegalArgumentException("NULL 혹은 빈 값으로 계산 불가능 합니다. 재입력 해주세요.");
        }
    }

    // 2. numberCheck
    public void numberCheck(String str) {

        if(ObjectUtils.equals(str, null) || str.isEmpty()){
            throw new IllegalArgumentException("정수가 입력되어야 할 자리에 NULL 혹은 빈 값이 입력 되었습니다. 재입력 해주세요.");
        }
        if(!str.matches("^[0-9]*$")){
            throw new IllegalArgumentException("숫자가 아닌 값이 입력 되었거나 소수가 입력되었습니다. 재입력 해주세요.");
        }
    }

    // 3. operatorCheck
    public void operatorCheck(String str){
        operatorList.add("+");
        operatorList.add("-");
        operatorList.add("*");
        operatorList.add("/");

        if(!operatorList.contains(str)){
            throw new IllegalArgumentException("연산자(+, -, *, /)가 아닌 값이 있습니다. 재입력 해주세요.");
        }
    }
}
