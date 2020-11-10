package study.racingcar;

import study.racingcar.domain.car.Engine;

/**
 * 자동차의 이동 성공을 담당
 */
public class NewEngine implements Engine {

    @Override
    public boolean isMovable() {
        return true;
    }
}
