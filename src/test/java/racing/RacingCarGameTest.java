package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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

    @Test
    @DisplayName("전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.")
    void testForwarding() {
        RacingCar racingCar = new RacingCar(new Operator(1L));
        for (int i = 0; i < 10; i++) {
            racingCar.race();
        }
        // int[] expected = new int[] {5, 8, 7, 3, 4, 4, 4, 6, 8, 8};
        assertThat(racingCar.getCurrentPosition()).isEqualTo(9);
    }

    @Test
    @DisplayName("자동차의 상태를 화면에 출력한다. 자동차 전진 횟수는 '-' 의 개수와 같다")
    void testDisplayResult() {
        RacingCar racingCar = new RacingCar(new Operator(1L));
        for (int i = 0; i < 10; i++) {
            racingCar.race();
        }
        String result = ResultView.display(List.of(racingCar));
        assertThat(result).isEqualTo("---------\n\n");
    }
}
