package carracing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarRacingTest {
    @DisplayName("참여하는 Car 객체들과 이동 시도 횟수를 가지는 레이싱 경기가 생성된다.")
    @Test
    void return_carRacing_instance() {
        CarRacing carRacing = new CarRacing(new String[]{"moon", "zi"}, 3);

        assertThat(carRacing.getCars()).isEqualTo(carRacing.getCars());
        assertThat(carRacing.getMoveTryCount()).isEqualTo(3);
        assertThat(carRacing.getCarsMoveStatusHistory())
                .isNotNull()
                .isInstanceOf(CarsMoveStatusHistory.class);
    }

}
