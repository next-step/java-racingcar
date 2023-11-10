package racingcar.application;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Cars;
import racingcar.ui.dto.RacingGameRequest;
import racingcar.ui.dto.RacingGameResponse;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("자동자 경주 서비스 테스트")
public class RacingCarGameServiceTest {
    private final int END_TURN = 5;
    private String inputCars = "pobi,crong,honux";

    @DisplayName("각 자동차가 움직인 상태 값을 가진 응답 객체를 생성한다.")
    @Test
    void getAllCarMoveCount() {
        RacingCarGameService service = new RacingCarGameService();
        Assertions.assertThat(service.start(new RacingGameRequest(inputCars, END_TURN)))
                .isInstanceOf(RacingGameResponse.class);
    }

    @DisplayName("게임 종료 횟수가 0 이하일 경우 예외가 발생한다.")
    @Test
    void checkEndTurn() {
        int endTurn = 0;
        RacingCarGameService service = new RacingCarGameService();
        assertThatIllegalArgumentException().isThrownBy(() -> {
            service.start(new RacingGameRequest(inputCars, endTurn));
        });
    }
}
