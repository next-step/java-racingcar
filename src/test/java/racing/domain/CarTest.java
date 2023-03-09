package racing.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.util.Random;

class CarTest {

    @Test
    @DisplayName("5자 초과한 자동차 이름은 예외 발생한다.")
    void longCarNameException() {
        Assertions.assertThatThrownBy(() -> new Car("123456"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차 위치 비교한다.")
    void compareBetweenCars() {
        Car carA = new Car("carA", 1);
        Car carB = new Car("carB", 2);

        Assertions.assertThat(carA.compareTo(carB)).isEqualTo(-1);
    }

    @Test
    @DisplayName("자동차 위치 비교한다.")
    void isEqualLocation() {
        Car carA = new Car("carA", 1);
        Car carB = new Car("carB", 1);

        Assertions.assertThat(carA.isEqualLocation(carB)).isTrue();
    }

    @DisplayName("랜덤값이 4이상일때 움직인다.")
    @ParameterizedTest
    @CsvSource({"1, true", "2, true", "3, true", "4, false", "5, false",
            "6, false", "7, false", "8, false", "9, false"})
    void stopTest(int randomResult, boolean isMove) {
        Car defaultCar = new Car("zero", 0);
        Car moveCar = new Car("test");
        moveCar.move(new Random() {
            @Override
            public int nextInt(int bound) {
                return randomResult;
            }
        });

        Assertions.assertThat(isSameLocation(defaultCar, moveCar)).isEqualTo(isMove);
    }

    private boolean isSameLocation(Car defaultCar, Car moveCar) {
        return moveCar.compareTo(defaultCar) == 0;
    }
}