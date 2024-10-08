package carracing;

import carracing.car.Car;
import carracing.car.Cars;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsMoveStatusHistoryTest {
    @DisplayName("자동차 경주 시도 횟수 별 차들의 이동 상태를 저장한다.")
    @Test
    void return_cars_moveStatus_by_carRacing_moveTryCount() {
        Car moon = new Car("moon");
        Car zi = new Car("zi");
        Cars cars = new Cars(List.of(moon, zi));
        CarsMoveStatusHistory carsMoveStatusHistory = new CarsMoveStatusHistory();

        carsMoveStatusHistory.save(cars);

        assertThat(carsMoveStatusHistory.moveTryCount()).isEqualTo(1);
    }
}