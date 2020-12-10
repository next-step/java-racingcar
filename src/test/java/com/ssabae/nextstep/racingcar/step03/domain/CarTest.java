package com.ssabae.nextstep.racingcar.step03.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.ssabae.nextstep.racingcar.step03.exception.CarNameInvalidException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * @author : leesangbae
 * @project : java-racingcar
 * @since : 2020-12-06
 */
@DisplayName("Car 객체 Test Class")
class CarTest {

    @Test
    @DisplayName("자동차가 두번 움직였을 경우 테스트")
    void moveCountTest() {
        Car car = new Car("Test");

        car.move(MoveState.GO);
        car.move(MoveState.GO);

        assertThat(car.getMoveCount()).isEqualTo(2);
        assertThat(car.getName()).isEqualTo("Test");

    }


    @Test
    @DisplayName("자동차가 움직이지 않았을 경우 테스트")
    void moveCountWithStayTest() {
        Car car = new Car("Test");

        car.move(MoveState.STAY);
        car.move(MoveState.STAY);

        assertThat(car.getMoveCount()).isEqualTo(0);
        assertThat(car.getName()).isEqualTo("Test");
    }


    @ParameterizedTest(name = "{displayName}[{index}] - \"{arguments}\"")
    @DisplayName("자동차가 생성 에러")
    @ValueSource(strings = {"", "abcdef"})
    void shouldCarNameInvalidExceptionTest(String value) {
        assertThatThrownBy(() -> new Car(value))
                .isInstanceOf(CarNameInvalidException.class);
    }

}
