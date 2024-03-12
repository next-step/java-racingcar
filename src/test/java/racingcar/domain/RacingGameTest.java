package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.fixture.DrivingStrategyFixture.ALWAYS_MOVE;
import static racingcar.fixture.DrivingStrategyFixture.NEVER_MOVE;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.fake.FakeCars;

public class RacingGameTest {

    private static final List<String> CAR_NAMES = List.of("a", "b", "c");
    private static final int FIVE_TIMES = 5;

    private final RacingGame racingGame = new RacingGame(CAR_NAMES);

    @Test
    @DisplayName("canDrive 반환값이 true라면 전진한다")
    void drive() {
        racingGame.drive(FIVE_TIMES, ALWAYS_MOVE);

        List<Integer> drivingDistances = racingGame.drivingDistances();
        assertThat(drivingDistances).containsExactly(FIVE_TIMES, FIVE_TIMES, FIVE_TIMES);
    }

    @Test
    @DisplayName("canDrive 반환값이 false라면 전진하지 않는다")
    void notDrive() {
        racingGame.drive(FIVE_TIMES, NEVER_MOVE);

        List<Integer> drivingDistances = racingGame.drivingDistances();
        assertThat(drivingDistances).containsExactly(0, 0, 0);
    }

    private String expectedResult() {
        StringBuilder expected = new StringBuilder();
        for (int round = 1; round <= FIVE_TIMES; round++) {
            expected.append(expectedRoundResult(round));
            expected.append('\n');
        }
        expected.deleteCharAt(expected.length() - 1);
        expected.deleteCharAt(expected.length() - 1);
        return expected.toString();
    }

    private String expectedRoundResult(int round) {
        StringBuilder sb = new StringBuilder();
        for (String carName : CAR_NAMES) {
            sb.append(carName).append(" : ").append("-".repeat(round)).append('\n');
        }
        return sb.toString();
    }

    @Test
    @DisplayName("우승자 이름 목록을 가져온다")
    void winners() {
        RacingGame racingGame = new RacingGame(new FakeCars());
        List<String> winnerNames = racingGame.winnerNames();

        assertThat(winnerNames).containsExactly("a", "b");
    }
}
