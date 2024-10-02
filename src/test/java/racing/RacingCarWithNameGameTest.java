package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarWithNameGameTest {

    @Test
    @DisplayName("사용자는 자동차 이름 목록, 이동 횟수를 입력해서 게임을 실행 할 수 있다.")
    void testStartRacingGame() {
        String totalCarNames = "pobi,crong,honux";
        String[] carNames = totalCarNames.split(",");
        int totalRacingCounts = 5;

        int result = RacingCarWithNameGame.start(totalCarNames, totalRacingCounts);

        // 게임 실행 결과 모든 차는 주어진 이동 수 만큼 실행되어야 한다.
        assertThat(result).isEqualTo(carNames.length * totalRacingCounts);
    }

    @Test
    @DisplayName("자동차 이름이 5글자를 초과할 경우 예외를 발생한다")
    void testCarNameOverFiveLetters() {
        assertThatThrownBy(() -> {
            RacingCarWithNameGame.start("pobi,crong,honux1", 5);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
