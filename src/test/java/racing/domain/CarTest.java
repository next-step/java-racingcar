package racing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private Car car;

    private static final int DEFAULT_STATE_FOR_TEST = 3;

    @BeforeEach
    void setUp() {
        car = new Car();
        car.setPosition(DEFAULT_STATE_FOR_TEST);
    }

    @ParameterizedTest
    @CsvSource(value = {"5:4", "2:3", "-1:3"}, delimiter = ':')
    @DisplayName("이동 조건에 부합 하는 경우만 전진하는지 테스트")
    void moveByCondition(int input, int expected) {
        assertThat(car.moveByCondition(input)).isEqualTo(expected);
    }
}
