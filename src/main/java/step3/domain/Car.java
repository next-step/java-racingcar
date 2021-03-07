package step3.domain;

import java.util.List;

import static step3.util.Constants.DEFAULT_POSITION;
import static step3.util.Constants.MOVE_CONDITION_VALUE;

/**
 * 자동차의 상태와 행위를 관리하는 클래스
 */
public class Car {

    private int position;

    private Car() {
        this.position = DEFAULT_POSITION;
    }

    // 자동차 생성
    public static Car of() {
        return new Car();
    }

    public int getPosition() {
        return position;
    }

    // 자동차의 전진 기능
    public Car move(int value) {
        if(isMove(value)) {
            position++;
        }
        return this;
    }

    // 자동차가 전진하기 위한 조건 처리
    private boolean isMove(int value) {
        return value >= MOVE_CONDITION_VALUE;
    }

    public static Record toRecord(Car car) {
        return new Record.Builder()
                .position(car.getPosition())
                .build();
    }
}
