package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car();
    }

    @DisplayName("자동차 전진 테스트")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    public void 값이_4이상일때_1칸_전진한다(int number) {
        car.moveAble(number);
        assertThat(car.getPosition()).isOne();
    }

    @DisplayName("자동차 전진 예외 테스트")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    public void 값이_4이하면_움직이지_않는다(int number) {
        car.moveAble(number);
        assertThat(car.getPosition()).isZero();
    }
}
