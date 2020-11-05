package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.RacingCarService;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {


    @DisplayName("initialCars() 테스트 : carCount만큼 Car 객체가 생성됐는지 확인")
    @Test
    void initialCars() {
        int carCount = 3;

        List<Car> cars = RacingCarService.initialCars(carCount);

        assertThat(cars.size()).isEqualTo(carCount);
    }

    @DisplayName("runByCar() 테스트 : 메소드 호출 후 Car의 상태는 전진하거나, 멈추거나 확인")
    @Test
    void runByCar() {
        Car car = new Car(); // postition 초기값은 0
        int position = RacingCarService.runByCar(car);

        assertThat(position).isBetween(0, 1);
    }

}
