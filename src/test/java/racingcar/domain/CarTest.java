package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car();
    }

    @DisplayName("Car 디폴트 생성자 테스트")
    @Test
    void noArgsConstructorTest() {
        assertThat(car.getPosition())
                .isZero();
    }

    @DisplayName("자동차 전진 테스트")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7})
    void moveTest(int number) {
        car.move(number);
        assertThat(car.getPosition())
                .isOne();
    }

    @DisplayName("자동차 전진 조건 예외 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void stopTest(int number) {
        car.move(number);
        assertThat(car.getPosition())
                .isZero();
    }
}
