package carracing.domain.carracing.dto;

import carracing.domain.carracing.Car;
import carracing.domain.carracing.Cars;
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

        assertThat(carsMoveStatusHistory.numberOfMoveTryCount()).isEqualTo(1);
    }

    @DisplayName("인자로 전달하는 이동시도 횟수 단계에 해당하는 Cars 객체를 반환한다.")
    @Test
    void carsBy() {
        Car moon = new Car("moon");
        Car zi = new Car("zi");
        Cars cars = new Cars(List.of(moon, zi));
        CarsMoveStatusHistory carsMoveStatusHistory = new CarsMoveStatusHistory();
        carsMoveStatusHistory.save(cars);
        moon.move(4);
        carsMoveStatusHistory.save(cars);

        Cars carsByFirstMoveTry = carsMoveStatusHistory.carsBy(0);
        Cars carsBySecondMoveTry = carsMoveStatusHistory.carsBy(1);

        assertThat(carsByFirstMoveTry.get()).hasSize(2);
        assertThat(carsBySecondMoveTry.get()).hasSize(2);
        assertThat(carsByFirstMoveTry.get().get(0).isSamePosition(0)).isTrue();
        assertThat(carsByFirstMoveTry.get().get(1).isSamePosition(0)).isTrue();
        assertThat(carsBySecondMoveTry.get().get(0).isSamePosition(1)).isTrue();
        assertThat(carsBySecondMoveTry.get().get(1).isSamePosition(0)).isTrue();
    }
}