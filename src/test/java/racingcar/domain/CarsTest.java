package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import racingcar.util.NumberGenerator;
import racingcar.util.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("자동차 컬렉션이 null 또는 비어있으면, 예외가 발생한다.")
    void construct(List<Car> cars) {
        assertThatThrownBy(() -> new Cars(cars))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 컬렉션에 빈 자동차가 포함되어있으면, 예외가 발생한다.")
    void constructWithCarsIncludingNull() {
        List<Car> cars = new ArrayList<>();
        cars.add(null);

        assertThatThrownBy(() -> new Cars(cars))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 컬렉션에 포함된 자동차를 한번 전진한다.")
    void move() {
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        List<Car> testCars = Arrays.asList(new Car(), new Car());
        Cars cars = new Cars(testCars);

        assertThat(cars.move(numberGenerator)).hasSize(testCars.size());
    }
}