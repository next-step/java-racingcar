package racingcar_step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("초간단 자동차 경주 테스트")
public class CarRacingTest {

    private int racingCarCount = 5;
    private int racingCount = 3;
    private CarRacingGame racingCarGame  = new CarRacingGame(racingCarCount, racingCount);

    @Test
    @DisplayName("Test1 입력값변수 2개중 1개 이상 값이 0 이하인 경우")
    void inputErrorTest() {
        int racingCarCount = 0;
        int racingCount = 3;

        CarRacingGame racingCarGame  = new CarRacingGame(racingCarCount, racingCount);

        assertThatIllegalArgumentException().isThrownBy(() -> {
            racingCarGame.initValue();
        });
    }

    @Test
    @DisplayName("Test2 자동자 이동 테스트")
    void moveTest() {
        racingCarGame.initValue();

        int forward = racingCarGame.setForward(7);
        assertThat(forward).isEqualTo(1);

        racingCarGame.move();
        List<Integer> carPositions = racingCarGame.getCarPositions();
        assertThat(carPositions).hasSize(5);
    }

    @Test
    @DisplayName("Test3 자동자 정지 테스트")
    void moveStopTest() {
        racingCarGame.initValue();

        int forward = racingCarGame.setForward(3);
        assertThat(forward).isEqualTo(0);

        racingCarGame.move();
        List<Integer> carPositions = racingCarGame.getCarPositions();
        assertThat(carPositions).hasSize(5);
    }
}
