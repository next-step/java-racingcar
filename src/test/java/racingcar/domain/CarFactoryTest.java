package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class CarFactoryTest {

    @ParameterizedTest
    @DisplayName("쉼표로 구분된 이름수 만큼 자동차를 생산한다")
    @ValueSource(strings = {"짱구,철수,맹구", "짱구,철수", "짱구"})
    void create(String input) {
        Cars cars = CarFactory.create(input);

        assertThat(cars.toStringNames()).contains(input);
    }
}
