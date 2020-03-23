package racing.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private Car car;

    private static final int DEFAULT_POSITION = 1;
    private static final int DEFAULT_POSITION_FOR_TEST = 3;

    @BeforeEach
    void setUp() {
        car = new Car();
    }

    @Test
    @DisplayName("자동차의 초기값이 0으로 설정되는지 테스트")
    void defaultCarPositionTest() {
        Assertions.assertEquals(DEFAULT_POSITION, car.getPosition());
    }

    @ParameterizedTest
    @CsvSource(value = {"5:4", "2:3", "-1:3"}, delimiter = ':')
    @DisplayName("이동 조건에 부합 하는 경우만 전진하는지 테스트")
    void moveByCondition(int input, int expected) {
        car.setPosition(DEFAULT_POSITION_FOR_TEST);

        assertThat(car.moveByCondition(input)).isEqualTo(expected);
    }
}
