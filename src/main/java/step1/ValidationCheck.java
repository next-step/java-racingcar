package step1;

import org.apache.commons.lang3.ObjectUtils;

import java.util.*;

public class ValidationCheck {
   ArrayList<String> operatorList = new ArrayList<>();
    // 1. nul Check
    public void nullCheck(String str) {

        if(ObjectUtils.equals(str, null) || str.isEmpty()){
            throw new IllegalArgumentException("NULL 값으로 계산 불가능 합니다. 재입력 해주세요.");
        }
    }

    // 2. operatorCheck
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
