package racingcar.domain;

import racingcar.exception.IllegalCountException;

public class NumberValidation {

    public int isValid(int count) {
        if(count >= 0)   return count;
        throw new IllegalCountException("시도 횟수는 0이상의 값이어야 합니다.");
    }
}
