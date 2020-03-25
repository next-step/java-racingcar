package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class RacingGameTest {

    private List<String> carNames;

    @BeforeEach
    public void setUp() {
        carNames = Arrays.asList("수형", "재성", "성현");
    }

    @Test
    @DisplayName("게임을 진행해서 자동차가 전진한다면 자동차의 위치가 변화한다")
    public void progressGameMoveCarsByRandom() {
        InputData inputData = new InputData(carNames, 5);
        RacingGame game = new RacingGame(inputData, () -> true);

        assertThat(getCarPositions(game.getCars())).contains(0, 0, 0);

        game.progress();
        assertThat(getCarPositions(game.getCars())).contains(1, 1, 1);
    }

    private List<Integer> getCarPositions(List<Car> cars) {
        return cars
                .stream()
                .map(c -> c.getPosition())
                .collect(toList());
    }

    @Test
    @DisplayName("자동차의 이름을 입력하면 참가하는 자동차로 등록된다")
    public void createCarsByNames() {
        InputData inputData = new InputData(carNames, 5);
        RacingGame game = new RacingGame(inputData, () -> true);

        assertThat(game.getCars()).hasSize(3);
    }

    @ParameterizedTest
    @CsvSource({"-1, 2", "0, 3", "-3, 5"})
    @DisplayName("입력된 차 대수가 1보다 작을 때 IllegalArgumentException이 발생한다")
    public void inputInvalidNumberOfCarsThrowIllegalArgumentException(int numberOfCars, int tryCount) {
        InputData inputData = new InputData(carNames, tryCount);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new RacingGame(inputData, new RandomMoveStrategy()));
    }

    @ParameterizedTest
    @CsvSource({"2, -1", "3, 0", "5, -3"})
    @DisplayName("입력된 시도 횟수가 1보다 작을 때 IllegalArgumentException이 발생한다")
    public void inputInvalidTryCountThrowIllegalArgumentException(int numberOfCars, int tryCount) {
        InputData inputData = new InputData(carNames, tryCount);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new RacingGame(inputData, new RandomMoveStrategy()));
    }
}
