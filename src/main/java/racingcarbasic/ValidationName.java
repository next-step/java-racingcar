package racingcarbasic;

import java.util.Arrays;

public class ValidationName {
    public void validateName(String[] carNameList) {
        Arrays.stream(carNameList)
                .filter(name -> name.length() <= 5)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("자동차 이름은 5글자를 초과할 수 없습니다."));
    }
}
