package carracing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsMoveStatusHistoryTest {
    @DisplayName("자동차 경주 시도 횟수 별 차들의 이동 상태를 저장한다.")
    @Test
    void return_cars_moveStatus_by_carRacing_moveTryCount() {
        Car car1 = new Car();
        car1.move(4);
        car1.move(4);
        Car car2 = new Car();
        CarsMoveStatusHistory carsMoveStatusHistory = new CarsMoveStatusHistory();

        carsMoveStatusHistory.save(List.of(car1, car2));

        assertThat(carsMoveStatusHistory.getCarsMoveStatusHistory()).hasSize(1);
        assertThat(carsMoveStatusHistory.getCarsMoveStatusHistoryByMoveTryCount(0)).hasSize(2);
    }
}