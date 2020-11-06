package study.racingcar;

import study.racingcar.car.Engine;

/**
 * 자동차의 이동 실패를 담당
 */
public class BrokenEngine implements Engine {

    @Override
    public boolean isMovable() {
        return false;
    }
    
}
