package carracing.domain.carracing;

import carracing.domain.carracing.dto.CarsMoveStatusHistory;
import carracing.domain.carracing.dto.RandomNumberMoveStrategy;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.tuple;

class CarRacingTest {
    @DisplayName("참여하는 Car 객체들과 이동 시도 횟수를 가지는 레이싱 경기가 생성된다.")
    @Test
    void return_carRacing_instance() {
        CarRacing carRacing = new CarRacing(new String[]{"moon", "zi"}, 3, new RandomNumberMoveStrategy());

        assertThat(carRacing.getMoveTryCount()).isEqualTo(3);
        assertThat(carRacing.getCarsMoveStatusHistory())
                .isNotNull()
                .isInstanceOf(CarsMoveStatusHistory.class);
    }

    @DisplayName("자동차 경주는 이동 시도 횟수만큼 실행된다.")
    @Test
    void start_carRacing() {
        CarRacing carRacing = new CarRacing(new String[]{"moon", "zi"}, 3, new RandomNumberMoveStrategy() {
            @Override
            public void move(Car car) {
                car.move();
            }
        });
        carRacing.start();

        assertThat(carRacing).extracting("cars")
                .extracting("cars", as(InstanceOfAssertFactories.LIST))
                .extracting("name.value", "position.value")
                .contains(tuple("moon", 3), tuple("zi", 3));
    }
}
