package racingcar.application;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

@DisplayName("자동자 경주 서비스 테스트")
public class RacingCarGameServiceTest {

    private final int CAR_COUNT = 5;

    @DisplayName("자동차 경주에 필요한 자동차들을 초기화한다.")
    @Test
    void initializeCars() {
        RacingCarGameService service = new RacingCarGameService();
        service.initializeCars(CAR_COUNT);
        Assertions.assertThat(service.numberOfCar()).isEqualTo(CAR_COUNT);
    }

    @DisplayName("각 자동차가 움직인 상태를 얻는다.")
    @Test
    void getAllCarMoveCount() {
        RacingCarGameService service = new RacingCarGameService();
        service.initializeCars(CAR_COUNT);
        Assertions.assertThat(service.getAllCarMoveCount()).isInstanceOf(List.class);
    }
}
