package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @Test
    @DisplayName("입력된 차 대수가 1보다 작을 때 IllegalArgumentException이 발생한다")
    public void inputInvalidNumberOfCarsThrowIllegalArgumentException() {
        InputData inputData = new InputData(Arrays.asList(), 3);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new RacingGame(inputData, new RandomMoveStrategy()));
    }

    @Test
    @DisplayName("입력된 시도 횟수가 1보다 작을 때 IllegalArgumentException이 발생한다")
    public void inputInvalidTryCountThrowIllegalArgumentException() {
        InputData inputData = new InputData(carNames, 0);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new RacingGame(inputData, new RandomMoveStrategy()));
    }
}
