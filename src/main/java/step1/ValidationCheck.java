package step1;

import org.apache.commons.lang3.ObjectUtils;

public class ValidationCheck {

    // 1. nul Check
    public void nullCheck(String str) {

        if(ObjectUtils.equals(str, null) || str.isEmpty()){
            throw new IllegalArgumentException("NULL 값으로 계산 불가능 합니다. 재입력 해주세요.");
        }

    }

    // 2. 사칙연산 확인
    public void operatorCheck(){

    }


}
