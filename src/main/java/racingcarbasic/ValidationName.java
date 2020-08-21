package racingcarbasic;

import java.util.Arrays;

public class ValidationName {
    public void validateName(String[] carNameList) {
        if(Arrays.stream(carNameList)
                .anyMatch(name -> name.length() > 5)) {
            throw new IllegalArgumentException("자동차 이름은 5글자를 초과할 수 없습니다.");
        };
    }
}
