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

        String expectedResult = expectedResult();
        assertThat(racingGame.getResult())
            .isEqualTo(expectedResult);
    }

    private String expectedResult() {
        StringBuilder expected = new StringBuilder();
        for (int i = 1; i <= 5; i++) {
            for (String carName : CAR_NAMES) {
                expected.append(carName).append(" : ").append("-".repeat(i)).append('\n');
            }
            expected.append('\n');
        }
        expected.deleteCharAt(expected.length()-1);
        expected.deleteCharAt(expected.length()-1);
        return expected.toString();
    }

    @Test
    @DisplayName("우승자 이름 목록을 가져온다")
    void getWinnerNames() {
        List<Car> listCars = List.of(new Car(() -> true, "a"), new Car(() -> true, "b"), new Car(() -> false, "c"));
        Cars cars = new Cars(listCars);
        cars.drive();

        RacingGame racingGame = new RacingGame(cars);
        String[] winnerNames = racingGame.getWinnerNames();

        assertThat(winnerNames).containsExactly("a", "b");
    }
}
