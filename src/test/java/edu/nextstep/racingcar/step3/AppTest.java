package edu.nextstep.racingcar.step3;

import edu.nextstep.racingcar.common.BusinessException;
import edu.nextstep.racingcar.step3.app.Car;
import edu.nextstep.racingcar.step3.app.Cars;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.stream.IntStream;

import static java.util.stream.Collectors.toCollection;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AppTest {

    @DisplayName("자동차 이동 가능 여부 확인 테스트")
    @Test
    void getMoveStrategy() {
        Car.MoveStrategy moveStrategy = App.getMoveStrategy(10, 4);
        assertThat(moveStrategy.isMove()).isIn(true, false);
    }

    @ParameterizedTest(name = "[{index}] 자동차의 이동 여부 계산 에러 테스트, numberOfRandoms={0}, threshold={1}")
    @CsvSource(value = {"10,10", "5,10"})
    void getValidator(int numberOfRandoms, int threshold) {
        Car.ParamsValidator validator = App.getValidator(numberOfRandoms, threshold);
        assertThatThrownBy(validator::validate).isInstanceOf(BusinessException.class);
    }

    @ParameterizedTest(name = "[{index}] 자동차 목록 테스트, numberOfCars={0}, numberOfRandoms={1}, threshold={2}")
    @CsvSource(value = {"5,10,4", "10,10,4"})
    void make(final int numberOfCars, final int numberOfRandoms, final int threshold) {
        Cars cars = IntStream.range(0, numberOfCars)
                .mapToObj(idx -> new Car(App.getValidator(numberOfRandoms, threshold),
                        App.getMoveStrategy(numberOfRandoms, threshold)))
                .collect(toCollection(Cars::new));

        assertThat(cars.size()).isEqualTo(numberOfCars);
    }
}