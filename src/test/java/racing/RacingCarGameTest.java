package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarGameTest {

    @Test
    @DisplayName("사용자는 자동차 수, 이동 횟수 를 입력해서 게임을 실행 할 수 있다.")
    void testStartRacingGame() {
        int totalCars = 2;
        int totalRacingCounts = 5;

        int result = RacingCarGame.start(totalCars, totalRacingCounts);

        // 게임 실행 결과 모든 차는 주어진 이동 수 만큼 실행되어야 한다.
        assertThat(result).isEqualTo(totalCars * totalRacingCounts);
    }

}
