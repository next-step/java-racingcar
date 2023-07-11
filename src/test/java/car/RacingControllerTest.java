package car;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import car.controller.RacingController;
import car.model.RacingGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingControllerTest {

    @Test
    @DisplayName("횟수 오류 나면 racingController 객체 생성 불가")
    void 횟수_오류_확인() {
        assertThatThrownBy(() -> new RacingController(new RacingGame("jj,jjj", -1)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("횟수 정상 컨트롤러 정상 동작")
    void 횟수_오류_정상_동작() {
        assertThatCode(() -> new RacingController(
            new RacingGame("jj,jjj", 1))
            .start())
            .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("시도 횟수에 따라 레이스가 정상 동작한다.")
    void 시도_횟수_바탕으로_레이스_정상_동작() {
        assertThatCode(() -> new RacingGame("jj, jjj", 3).runRaceOnce())
            .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("시도 횟수 입력보다 레이스를 더 많이 돌면, 오류 반환한다.")
    void 시도_횟수_바탕으로_레이스_오류_빌생() {
        RacingGame racingGame = new RacingGame("jj,jjj", 3);
        RacingController racingController = new RacingController(racingGame);

        racingController.start();
        assertThatThrownBy(() -> racingGame.runRaceOnce())
            .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    @DisplayName("이름 오류 확인")
    void 이름_오류_확인() {
        assertThatCode(
            () -> new RacingController(new RacingGame("jjjjjj,jjj", 1))
                .start())
            .isInstanceOf(IllegalArgumentException.class);
    }

}
