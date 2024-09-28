package racingcar.model;

import racingcar.exception.ForwardNumberException;

public class ForwardNumber {
    public ForwardNumber(int number) {
        if (number < 0 || number > 9) {
            throw new ForwardNumberException("0~9 사이의 숫자 외에는 전진숫자로 허용되지 않습니다.");
        }
    }
}
