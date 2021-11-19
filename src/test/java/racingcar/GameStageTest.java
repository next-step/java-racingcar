package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.GameConfig;
import racingcar.domain.GameResult;

public class GameStageTest {


    @ValueSource(strings = "pobi,crong,hounx")
    @ParameterizedTest(name = "3개의 참가 자동차가 생성되어야 한다.")
    void initCarTest(String joiningCarNames) throws NoSuchFieldException, IllegalAccessException {
        Participants participants = Participants.join(joiningCarNames);

        GameStage gameStage = GameStage.init(new GameConfig(participants, 10));
        List<Car> cars = getCarsByReflection(gameStage);
        List<String> names = getNamesByReflection(participants);

        assertThat(cars).hasSize(names.size());
    }


    @ValueSource(ints = -5)
    @ParameterizedTest(name = "시도할 횟수가 {arguments}인 경우, IllegalArgumentException이 발생한다.")
    void initRoundIllegalArgumentExceptionTest(int numberOfRound) {
        Participants participants = Participants.join("pobi,crong,hounx");

        assertThatIllegalArgumentException()
            .isThrownBy(() -> GameStage.init(new GameConfig(participants, numberOfRound)));
    }

    @ValueSource(ints = {3, 5, 8})
    @ParameterizedTest(name = "Game 결과의 진행판의 갯수는, 게임 회차({arguments})만큼 생성된다.")
    void progressSizeTest(int numberOfRound) {
        GameResult gameResult = new GameResult();

        IntStream.range(0, numberOfRound)
            .forEach(round -> gameResult.record(round, Car.create("init")));

        assertThat(gameResult.getProgress()).hasSize(numberOfRound);
    }

    @SuppressWarnings("unchecked")
    private List<String> getNamesByReflection(Participants participants)
        throws NoSuchFieldException, IllegalAccessException {
        Field namesField = Participants.class.getDeclaredField("names");
        namesField.setAccessible(true);

        return (List<String>) namesField.get(participants);
    }

    @SuppressWarnings("unchecked")
    private List<Car> getCarsByReflection(GameStage gameStage)
        throws NoSuchFieldException, IllegalAccessException {
        Field carsField = GameStage.class.getDeclaredField("cars");
        carsField.setAccessible(true);

        return (List<Car>) carsField.get(gameStage);
    }
}
