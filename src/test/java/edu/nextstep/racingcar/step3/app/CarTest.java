package edu.nextstep.racingcar.step3.app;

import edu.nextstep.racingcar.common.BusinessException;
import edu.nextstep.racingcar.step3.error.CarError;
import edu.nextstep.racingcar.step3.util.RandomUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @DisplayName("자동차의 이동 여부 계산 테스트")
    @Test
    void is_move() {

        Supplier<Boolean> movement = () -> {
            RandomUtils randomUtils = new RandomUtils(10);
            return randomUtils.getRandomNumber() >= 4;
        };

        Car car = new Car(() -> {
        }, movement);
        assertThat(car.isMove()).isIn(true, false);
    }

    @ParameterizedTest(name = "[{index}] 자동차의 이동 여부 계산 에러 테스트, input={0}, expected={1}")
    @CsvSource(value = {"10,10", "5,10"})
    void is_move_test_error(int numberOfRandoms, int threshold) {

        Car.ParamsValidator validator = () -> {
            if (numberOfRandoms <= threshold) {
                throw new BusinessException(CarError.INVALID_VALUE_GREAT_THAN_THRESHOLD);
            }
        };

        Supplier<Boolean> movement = () -> {
            RandomUtils randomUtils = new RandomUtils(numberOfRandoms);
            return randomUtils.getRandomNumber() >= threshold;
        };

        assertThatThrownBy(() -> new Car(validator, movement))
                .isInstanceOf(BusinessException.class);
    }
}