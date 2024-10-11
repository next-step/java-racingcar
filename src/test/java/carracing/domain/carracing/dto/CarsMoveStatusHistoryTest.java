package carracing.domain.carracing.dto;

import carracing.domain.carracing.Car;
import carracing.domain.carracing.Cars;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

/**
 * dto 클래스는 단위 테스트 대상이 아니다.
 */
class CarsMoveStatusHistoryTest {
    @DisplayName("자동차 경주 시도 횟수 별 차들의 이동 상태를 저장한다.")
    @Test
    void return_cars_moveStatus_by_carRacing_moveTryCount() {
        Cars cars = new Cars(List.of(
                new Car("moon"),
                new Car("zi")));
        CarsMoveStatusHistory carsMoveStatusHistory = new CarsMoveStatusHistory();

        carsMoveStatusHistory.save(cars);

        assertThat(carsMoveStatusHistory.numberOfMoveTryCount()).isEqualTo(1);
        assertThat(carsMoveStatusHistory.carsBy(0)).isEqualTo(cars);
    }

    @DisplayName("인자로 전달하는 이동시도 횟수 단계에 해당하는 Cars 객체를 반환한다.")
    @Test
    void carsBy() {
        Car moon = new Car("moon");
        Car zi = new Car("zi");
        Cars cars = new Cars(List.of(moon, zi));
        CarsMoveStatusHistory carsMoveStatusHistory = new CarsMoveStatusHistory();
        carsMoveStatusHistory.save(cars);
        moon.move();
        carsMoveStatusHistory.save(cars);

        Cars carsByFirstMoveTry = carsMoveStatusHistory.carsBy(0);
        Cars carsBySecondMoveTry = carsMoveStatusHistory.carsBy(1);

        assertThat(carsByFirstMoveTry).extracting("cars", as(InstanceOfAssertFactories.LIST))
                .extracting("name.value", "position.value")
                .contains(tuple("moon", 0), tuple("zi", 0));
        assertThat(carsBySecondMoveTry).extracting("cars", as(InstanceOfAssertFactories.LIST))
                .extracting("name.value", "position.value")
                .contains(tuple("moon", 1), tuple("zi", 0));
    }
}