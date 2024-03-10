package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    @DisplayName("Car를 만드는 지에 대한 Test")
    void makeCarTest() {
        Car car = new Car();
        assertThat(car).isInstanceOf(Car.class);
    }

    @Test
    @DisplayName("만들어진 Car의 초기 거리값 Test")
    void compareDistanceTest() {
        // given
        Car car1 = new Car();
        Car car2 = new Car();
        // when
        int car1Dinstance = car1.getDistance();
        int car2Dinstance = car2.getDistance();
        //then
        assertThat(car1Dinstance).isEqualTo(car2Dinstance);
    }

    @ParameterizedTest
    @DisplayName("주어진 값에 대한 Car의 정지 Test")
    @ValueSource(ints = {0, 1})
    void stopCarTest(int data) {
        // given
        Car car = new Car();
        // when
        car.move(data);
        int distance = car.getDistance();
        // then
        assertThat(distance).isEqualTo(0);
    }

    @ParameterizedTest
    @DisplayName("주어진 값에 대한 Car의 정지 Test")
    @ValueSource(ints = {4, 9})
    void moveCarTest(int data) {
        // given
        Car car = new Car();
        // when
        car.move(data);
        int distance = car.getDistance();
        // then
        assertThat(distance).isEqualTo(1);
    }
}
