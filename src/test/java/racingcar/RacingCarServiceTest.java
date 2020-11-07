package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Motor;
import racingcar.model.TesterMotor;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarServiceTest {

    @DisplayName("initialCars() 테스트 : carCount만큼 Car 객체가 생성됐는지 확인")
    @Test
    void initialCars() {
        int carCount = 3;
        Motor motor = new TesterMotor();

        List<Car> cars = RacingCarService.initialCars(carCount, motor);

        assertThat(cars.size()).isEqualTo(3);
    }
}
