package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("car1");
    }

    @Test
    @DisplayName("Car를 만드는 지에 대한 Test")
    void makeCarTest() {
        assertThat(car).isInstanceOf(Car.class);
    }

    @Test
    @DisplayName("만들어진 Car의 초기 거리값 Test")
    void compareDistanceTest() {
        // given
        // when
        int carDistance = car.getDistance();

        //then
        assertThat(carDistance).isEqualTo(0);
    }

    @ParameterizedTest
    @DisplayName("주어진 값에 대한 Car의 정지 Test")
    @ValueSource(ints = {0, 1})
    void stopCarTest(int data) {
        // when
        car.move(data);
        int carDistance = car.getDistance();
        // then
        assertThat(carDistance).isEqualTo((0));
    }

    @ParameterizedTest
    @DisplayName("주어진 값에 대한 Car의 정지 Test")
    @ValueSource(ints = {4, 9})
    void moveCarTest(int data) {
        // when
        car.move(data);
        int carDistance = car.getDistance();
        // then
        assertThat(carDistance).isEqualTo(1);
    }
}
