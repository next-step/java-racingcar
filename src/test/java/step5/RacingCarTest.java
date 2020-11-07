package step5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.game.GameHistory;
import step3.game.RacingGame;
import step3.game.RacingGameImpl;
import step5.domain.model.car.RacingCar;
import step5.strategy.MoveStrategy;
import step5.strategy.TestMoveStrategy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class RacingCarTest {
    private RacingGame racingGame;

    @BeforeEach
    void setup() {
        racingGame = new RacingGameImpl();
    }


    @DisplayName("무조건 전진 전략 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6,7,8,9})
    public void moveStrategyTest(int count) throws Exception{
        MoveStrategy moveStrategy = TestMoveStrategy.unconditionalForwardStrategy();
        RacingCar testCar = new RacingCar("test");

        for (int i = 0; i < count; i++) {
            testCar.go(moveStrategy);
        }
        assertThat(testCar.currentProgress()).isEqualTo(count);
    }

    @DisplayName("무조건 멈춤 전략 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6,7,8,9})
    public void stopStrategyTest(int count) throws Exception{
        MoveStrategy moveStrategy = TestMoveStrategy.unconditionalStopStrategt();
        RacingCar testCar = new RacingCar("test");

        for (int i = 0; i < count; i++) {
            testCar.go(moveStrategy);
        }
        assertThat(testCar.currentProgress()).isEqualTo(0);
    }

    @DisplayName("이름 5글자 제한 테스")
    @ParameterizedTest
    @MethodSource("provideCarNameAndException")
    public void stopStrategyTest(String inputCarName, String error) throws Exception{
        assertThatIllegalArgumentException()
                .isThrownBy(()->{
                    RacingCar racingCar = new RacingCar(inputCarName);
                }).withMessage(error);
    }
    public static Stream<Arguments> provideCarNameAndException(){
        return Stream.of(
                Arguments.of("testCar", Constant.ERROR_5OVER_NAME)
        );
    }

    @DisplayName("자동차 경주 우승자 테스트")
    @ParameterizedTest
    @MethodSource("provideTestRacingInfo")
    public void winnerTest(GameHistory gameHistory, List<String> winners) {
        assertThat(gameHistory.getWinner()).contains(winners);

    }

    private static Stream<Arguments> provideTestRacingInfo() {
        GameHistory catsbiWinner = new GameHistory();
        GameHistory hansolAndSolWinner = new GameHistory();
        catsbiWinner.addHistory(1, new HashMap<String, Integer>(){{ put("catsbi", 3);put("hansol", 2);put("sol", 2);}});
        hansolAndSolWinner.addHistory(1, new HashMap<String, Integer>(){{ put("catsbi", 3);put("hansol", 5);put("sol", 5);}});
        return Stream.of(
                Arguments.of(catsbiWinner, Arrays.asList("catsbi")),
                Arguments.of(hansolAndSolWinner, Arrays.asList("hansol", "sol"))
        );
    }
}
