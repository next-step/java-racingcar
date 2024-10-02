package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.util.FixedNumberGenerator;
import racing.util.RandomNumberGenerator;

class CarTest {

    @DisplayName("자동차가 생성되면 position 0인 상태로 생성이 되는지")
    @Test
    void createCarTest() {
        Car car = Car.create("테스터", new RandomNumberGenerator());
        assertThat(car.getCarInfo()
                .getPosition()).isZero();
    }

    @DisplayName("생성된 자동차 명이 5자 초과이면 예외를 잘 발생시키는지")
    @Test
    void createCarTest_withOverSizedName() {
        assertThatThrownBy(() -> Car.create("테스트자동차", new RandomNumberGenerator()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차가 생성된 랜덤 난수가 4 이상인 경우에만 한 칸 전진하는지")
    @ParameterizedTest
    @CsvSource(value = {"4:1", "3:0"}, delimiter = ':')
    void carMoveTest(int given, int expected) {
        Car car = Car.create("테스터", new FixedNumberGenerator(given));
        car.move();
        assertThat(car.getCarInfo()
                .getPosition()).isEqualTo(expected);
    }
}
