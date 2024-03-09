package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingGameTest {

    private static final String[] CAR_NAMES = {"a", "b", "c"};

    @Test
    @DisplayName("canDrive 반환값이 true라면 전진한다")
    void drive() {
        RacingGame racingGame = new RacingGame(CAR_NAMES);
        racingGame.drive(5, () -> true);

        List<Integer> drivingDistances = racingGame.drivingDistances();
        assertThat(drivingDistances).containsExactly(5, 5, 5);
    }

    @Test
    @DisplayName("canDrive 반환값이 false라면 전진하지 않는다")
    void notDrive() {
        RacingGame racingGame = new RacingGame(CAR_NAMES);
        racingGame.drive(5, () -> false);

        List<Integer> drivingDistances = racingGame.drivingDistances();
        assertThat(drivingDistances).containsExactly(0, 0, 0);
    }

    @Test
    @DisplayName("-의 개수를 이용해 주행 거리를 표현한다")
    void result() {
        RacingGame racingGame = new RacingGame(CAR_NAMES);
        racingGame.drive(5, () -> true);

        String expectedResult = expectedResult();
        assertThat(racingGame.result())
            .isEqualTo(expectedResult);
    }

    private String expectedResult() {
        StringBuilder expected = new StringBuilder();
        for (int round = 1; round <= 5; round++) {
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
        Cars cars = new Cars() {
            @Override
            public Winners winners() {
                return Winners.from(
                    List.of(new Car("a"), new Car("b"))
                );
            }
        };
        RacingGame racingGame = new RacingGame(cars);
        List<String> winnerNames = racingGame.winnerNames();

        assertThat(winnerNames).containsExactly("a", "b");
    }
}
