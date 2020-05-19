package step3.racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("car 객체 생성 및 기본값 테스트")
    @Test
    public void makeNewCarObject() {
        Car car = new Car("abc", new RandomMovingStrategy());
        assertThat(car.getPosition()).isEqualTo(0);
    }

    /*
    @DisplayName("car 객체가 움직이는지 확인하는 테스트")
    @ParameterizedTest
    @ValueSource(ints = {5, 10, 15, 8, 6, 3, 21, 9})
    public void checkWhetherCarObjectMoves(int carCounts) {
        List<Car> cars = CarFactory.makeCars(carCounts);
        cars.forEach(Car::move);
        assertThat(cars.stream().map(Car::getPosition))
                .contains(0, 1);
    }

     */
}
