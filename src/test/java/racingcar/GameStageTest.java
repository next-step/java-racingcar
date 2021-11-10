package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.dto.GameConfig;
import racingcar.dto.GameResult;

public class GameStageTest {


    @ValueSource(ints = {3, 5, 10})
    @ParameterizedTest(name = "{arguments}개의 참가 자동차가 생성되어야 한다.")
    void initCarTest(int numberOfCars) throws NoSuchFieldException, IllegalAccessException {
        GameStage gameStage = GameStage.init(new GameConfig(numberOfCars, 10));
        List<Car> cars = getCarsByReflection(gameStage);

        assertThat(cars).hasSize(numberOfCars);
    }

    @ValueSource(ints = {0, -1})
    @ParameterizedTest(name = "자동차 생성 대수가 {arguments}인 경우, IllegalArgumentException이 발생한다.")
    void initCarIllegalArgumentExceptionTest(int numberOfCars) {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> GameStage.init(new GameConfig(numberOfCars, 10)));
    }

    @ValueSource(ints = -5)
    @ParameterizedTest(name = "시도할 횟수가 {arguments}인 경우, IllegalArgumentException이 발생한다.")
    void initRoundIllegalArgumentExceptionTest(int numberOfRound) {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> GameStage.init(new GameConfig(1, numberOfRound)));
    }

    @ValueSource(ints = {3, 5, 8})
    @DisplayName(value = "Game 결과의 진행판의 갯수는, 게임 회차({arguments})만큼 생성된다.")
    void progressSizeTest(int numberOfRound) {
        GameResult gameResult = new GameResult();

        IntStream.range(0, numberOfRound)
            .forEach(round -> gameResult.record(round, "-"));

        assertThat(gameResult.getProgress()).hasSize(numberOfRound);
    }


    private List<Car> getCarsByReflection(GameStage gameStage)
        throws NoSuchFieldException, IllegalAccessException {
        Field carsField = GameStage.class.getDeclaredField("cars");
        carsField.setAccessible(true);

        return (List<Car>) carsField.get(gameStage);
    }
}
