package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import racingcar.car.RacingCar;
import racingcar.game.GameHistory;
import racingcar.game.RacingGame;
import racingcar.game.RacingGameImpl;
import racingcar.game.RacingInfomation;
import racingcar.strategy.MoveStrategy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;


@DisplayName("RacingGame 테스")
public class RacingCarTest {
    private RacingGame racingGame;

    @BeforeEach
    void setup() {
        racingGame = new RacingGameImpl();
    }

    @DisplayName("자동차의 전진 전략 테스트")
    @ParameterizedTest
    @CsvSource(value = {"0:false", "1:false", "2:false", "3:false", "4:true", "5:true", "6:true", "7:true", "8:true", "9:true"}, delimiter = ':')
    public void allowMoveTest(int input, boolean resultBool) {
        MoveStrategy moveStrategy = () -> input >= Constant.ANCHOR_POINT;
        RacingCar racingCar = new RacingCar("");
        assertThat(racingCar.allowMove(moveStrategy)).isEqualTo(resultBool);
    }


    @DisplayName("레이싱게임 정보 null 테스트")
    @ParameterizedTest
    @NullSource
    public void nullAndEmptyRacingTest(RacingInfomation input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> racingGame.execute(input, MoveStrategy.defaultStrategy(new Random())))
                .withMessageStartingWith("빈 공백");
    }


    @DisplayName("자동차 이름 5글자 초과 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"catsbi,hansol,fivetest", "catsbitwo,hansol,five"})
    public void carName5OverTest(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(()-> new RacingInfomation.Builder(3).carNames(input))
                .withMessage(Constant.ERROR_5OVER_NAME);
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
