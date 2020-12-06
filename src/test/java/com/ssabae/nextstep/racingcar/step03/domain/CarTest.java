package com.ssabae.nextstep.racingcar.step03.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author : leesangbae
 * @project : java-racingcar
 * @since : 2020-12-06
 */
class CarTest {

    @Test
    @DisplayName("자동차가 두번 움직였을 경우 테스트")
    void moveCountTest() {
        Car car = new Car();

        car.move(MoveState.GO);
        car.move(MoveState.GO);

        assertThat(car.getMoveCount()).isEqualTo(2);
    }


    @Test
    @DisplayName("자동차가 움직이지 않았을 경우 테스트")
    void moveCountWithStayTest() {
        Car car = new Car();

        car.move(MoveState.STAY);
        car.move(MoveState.STAY);

        assertThat(car.getMoveCount()).isEqualTo(0);
    }

}
