package study.carracing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9, 10})
    @DisplayName("random 값이 4이상일 경우 자동차가 1칸 전진한다.")
    void moveCar(int randomValue) {
        Car car = new Car(new RandomGeneratorImpl());

        car.go(randomValue);

        int position = car.getPosition();
        assertThat(position).isEqualTo(2);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("random 값이 4미만일 경우 자동차는 움직이지 않는다.")
    void dontMoveCar(int randomValue) {
        Car car = new Car(new RandomGeneratorImpl());

        car.go(randomValue);

        int position = car.getPosition();
        assertThat(position).isEqualTo(1);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:'--'", "2:'---'", "3:'----'", "4:'-----'", "5:'------'"}, delimiter = ':')
    @DisplayName("차가 전진 회수만큼 대쉬(-)가 출력된다.")
    void carToString(int forward, String expected) {
        Car car = new Car(new RandomGeneratorImpl());

        for (int i = 0; i < forward; i++) {
            car.go(4);
        }


        String actual = car.toString();
        assertThat(actual).isEqualTo(expected);
    }
}
