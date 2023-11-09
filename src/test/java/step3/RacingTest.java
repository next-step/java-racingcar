package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step3.domain.Car;
import step3.helper.CarFactory;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5})
    @DisplayName("자동차를 N대 생성한다.")
    void create_cars(int size) {
        List<Car> cars = CarFactory.createCars(size);
        assertThat(cars).hasSize(size);
        assertThat(cars).doesNotContainNull();
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 9})
    @DisplayName("자동차의 랜덤 숫자가 4이상일 때 한칸 움직인다.")
    void move_test(int randomNumber) {
        Car car = new Car();

        int prevForwardCount = car.getForwardCount();
        car.move(randomNumber);
        int nextForwardCount = car.getForwardCount();

        assertThat(prevForwardCount).isEqualTo(nextForwardCount - 1);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3})
    @DisplayName("자동차의 랜덤 숫자가 3이하일 때 멈춘다.")
    void stop_test(int randomNumber) {
        Car car = new Car();

        int prevForwardCount = car.getForwardCount();
        car.move(randomNumber);
        int nextForwardCount = car.getForwardCount();

        assertThat(prevForwardCount).isEqualTo(nextForwardCount);
    }

}
