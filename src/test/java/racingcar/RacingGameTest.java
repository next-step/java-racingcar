package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingGameTest {

    private static final String[] CAR_NAMES = {"a", "b", "c"};

    @Test
    @DisplayName("canDrive 반환값이 true라면 전진한다")
    void drive() throws Exception {
        RacingGame racingGame = new RacingGame(() -> true, CAR_NAMES);
        racingGame.drive(5);

        List<Integer> drivingDistances = racingGame.drivingDistances();
        assertThat(drivingDistances).containsExactly(5, 5, 5);
    }

    @Test
    @DisplayName("canDrive 반환값이 false라면 전진하지 않는다")
    void notDrive() throws Exception {
        RacingGame racingGame = new RacingGame(() -> false, CAR_NAMES);
        racingGame.drive(5);

        List<Integer> drivingDistances = racingGame.drivingDistances();
        assertThat(drivingDistances).containsExactly(0, 0, 0);
    }

    @Test
    @DisplayName("-의 개수를 이용해 주행 거리를 표현한다")
    void getResult() throws Exception {
        RacingGame racingGame = new RacingGame(() -> true, CAR_NAMES);
        racingGame.drive(5);

        assertThat(racingGame.getResult())
            .isEqualTo("-\n-\n-\n\n"
                + "--\n--\n--\n\n"
                + "---\n---\n---\n\n"
                + "----\n----\n----\n\n"
                + "-----\n-----\n-----");
    }
}
