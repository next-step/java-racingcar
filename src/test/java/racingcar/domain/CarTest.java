package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("입력 받은 number 만큼 car 가 만들어진다.")
    void makeCarsByTest(int number) {
        List<Car> cars = Car.makeCarsBy(number);
        assertThat(cars).hasSize(number);
    }

    @ParameterizedTest
    @CsvSource({"3,false", "4,true", "5,true", "6,true"})
    @DisplayName("random 으로 들어온 값이 4 이상인 경우에만 전진한다.")
    void moveForwardByConditionTest(int number, boolean expected) {
        Car car = new Car(0);
        car.moveForwardByCondition(number);
        assertThat(car.getPosition() > 0).isEqualTo(expected);
    }
}