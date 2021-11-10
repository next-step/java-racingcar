package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.lang.reflect.Field;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.dto.GameConfigDto;

public class GameStageTest {


    @ValueSource(ints = {3, 5, 10})
    @ParameterizedTest(name = "{arguments}개의 참가 자동차가 생성되어야 한다.")
    void initCarTest(int numberOfCars) throws NoSuchFieldException, IllegalAccessException {
        GameStage gameStage = GameStage.init(new GameConfigDto(numberOfCars, 10));
        Car[] cars = getCarsByReflection(gameStage);

        assertThat(cars).hasSize(numberOfCars);
    }


    @ValueSource(ints = {0, -1})
    @ParameterizedTest(name = "자동차 생성 대수가 {arguments}인 경우, IllegalArgumentException이 발생한다.")
    void initCarIllegalArgumentExceptionTest(int numberOfCars) {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> GameStage.init(new GameConfigDto(numberOfCars, 10)));
    }

    @ValueSource(ints = -5)
    @ParameterizedTest(name = "시도할 횟수가 {arguments}인 경우, IllegalArgumentException이 발생한다.")
    void initRoundIllegalArgumentExceptionTest(int numberOfRound) {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> GameStage.init(new GameConfigDto(1, numberOfRound)));
    }

    private Car[] getCarsByReflection(GameStage gameStage)
        throws NoSuchFieldException, IllegalAccessException {
        Field carsField = GameStage.class.getDeclaredField("cars");
        carsField.setAccessible(true);

        return (Car[]) carsField.get(gameStage);
    }


}
