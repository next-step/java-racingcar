package edu.nextstep.racingcar.step3.app;

import edu.nextstep.racingcar.common.BusinessException;
import edu.nextstep.racingcar.step3.util.RandomUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @DisplayName("자동차의 이동 여부 계산 테스트")
    @Test
    void is_move() {
        Car car = new Car(10, 4, new RandomUtils());
        assertThat(car.isMove()).isIn(true, false);
    }

    @DisplayName("자동차의 이동 여부 계산 에러 테스트")
    @Test
    void is_move_test_error() {
        assertThatThrownBy(() -> new Car(10, 10, new RandomUtils()))
                .isInstanceOf(BusinessException.class);
    }
}