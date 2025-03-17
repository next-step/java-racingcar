package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.game.Car;
import step3.game.CarFactory;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarFactoryTest {

    @Test
    @DisplayName("주어진 개수 만큼 자동차를 생성하는지 체크한다.")
    public void createCarsTest() {
        // given
        int carCount = 3;
        // when
        List<Car> cars = CarFactory.createCars(carCount);
        // then
        assertThat(cars).hasSize(carCount);
    }
}
