package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingGameTest {

    private static final List<String> CAR_NAMES = List.of("a", "b", "c");
    private static final DrivingStrategy ALWAYS_MOVE = () -> true;
    private static final DrivingStrategy NEVER_MOVE = () -> false;
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

    @Test
    @DisplayName("-의 개수를 이용해 주행 거리를 표현한다")
    void result() {
        racingGame.drive(FIVE_TIMES, ALWAYS_MOVE);

        String expectedResult = expectedResult();
        assertThat(racingGame.result())
            .isEqualTo(expectedResult);
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

class FakeCars extends Cars {

    public static final List<Car> FAKE_CAR_LIST = List.of(new Car("a"), new Car("b"));

    @SuppressWarnings("all")
    public FakeCars() {
        super(FAKE_CAR_LIST);
    }

    @Override
    public Winners winners() {
        return new Winners(FAKE_CAR_LIST);
    }
}
