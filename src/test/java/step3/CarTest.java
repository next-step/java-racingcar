package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step3.model.Car;
import step3.util.numberGenerator.FixedNumberGenerator;
import step3.util.numberGenerator.NumberGenerator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    Car car;

    @BeforeEach
    void beforeEach() {
        car = new Car();
    }

    @Test
    @DisplayName("Car 객체를 생성하였을 때, 움직임 횟수는 0으로 초기화 되어야 한다.")
    void CarInitTest() {
        assertThat(car).extracting("moveCnt").isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 6, 7})
    @DisplayName("입력된 숫자가 4 이상인 경우 자동차는 움직인다")
    void moveCar_over4(int number) {
        NumberGenerator fixedOverNumberGenerator = new FixedNumberGenerator();
        car.decideMoveOrStop(fixedOverNumberGenerator.generate(number));
        assertThat(car).extracting("moveCnt").isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("입력된 숫자가 4 미만인 경우 자동차는 움직이지 않는다.")
    void moveCar_under4(int number) {
        NumberGenerator fixedLowerNumberGenerator = new FixedNumberGenerator();
        car.decideMoveOrStop(fixedLowerNumberGenerator.generate(number));
        assertThat(car).extracting("moveCnt").isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {10, 11, 12})
    @DisplayName("게임에서 필요한 숫자 범위를 넘기면 Exception 발생")
    void numberOfRangeTest(int number) {
        Car car = new Car();
        NumberGenerator numberGenerator = new FixedNumberGenerator();
        assertThatThrownBy(() -> {
            car.decideMoveOrStop(numberGenerator.generate(number));
        }).isInstanceOf(RuntimeException.class);
    }
}