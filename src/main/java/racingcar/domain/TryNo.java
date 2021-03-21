/*
 * 자동차 경주의 시도 횟수를 원시값으로 포장한 불변 객체
 *
 * @author hj-woo
 * @version 1.0
 * */

package racingcar.domain;

import racingcar.utils.ErrorMessage;

import java.util.Objects;

public class TryNo {

    private static final int INTIAL_NUM = 0;

    private final int tryNo;
    private int pointer;

    public TryNo(int tryNo) {
        if (tryNo < 0) {
            throw new IllegalArgumentException(ErrorMessage.LOWER_TRYNO);
        }
        this.tryNo = tryNo;
        this.pointer = INTIAL_NUM;
    }


    public boolean isZero() {
        if (tryNo == INTIAL_NUM) {
            return true;
        }
        return false;
    }

    public boolean next(){
        pointer++;
        return pointer <= tryNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TryNo tryNo1 = (TryNo) o;
        return tryNo == tryNo1.tryNo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tryNo);
    }


}
