package racingcar.application;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.ui.dto.RacingGameRequest;
import racingcar.ui.dto.RacingGameResponse;

@DisplayName("자동자 경주 서비스 테스트")
public class RacingCarGameServiceTest {
    private final int INITIAL_CAR_NUMBER = 5;

    @DisplayName("각 자동차가 움직인 상태 값을 가진 응답 객체를 생성한다.")
    @Test
    void getAllCarMoveCount() {
        RacingCarGameService service = new RacingCarGameService(new RacingGameRequest(INITIAL_CAR_NUMBER));
        Assertions.assertThat(service.start()).isInstanceOf(RacingGameResponse.class);
    }
}
