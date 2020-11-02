package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import step3.strategy.MoveStrategy;
import step3.car.RacingCar;
import step3.game.RacingGame;
import step3.game.RacingGameImpl;
import step3.game.RacingInfomation;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertTrue;


@DisplayName("RacingGame 테스")
public class RacingCarTest {
    private RacingGame racingGame;

    @BeforeEach
    void setup() {
        racingGame = new RacingGameImpl();
    }

    @DisplayName("자동차의 전진 전략 테스트")
    @ParameterizedTest
    @CsvSource(value = {"0:false", "1:false", "2:false", "3:false", "4:true", "5:true", "6:true", "7:true", "8:true", "9:true"},delimiter = ':')
    public void allowMoveTest(int input, boolean resultBool) {
        MoveStrategy moveStrategy = ()-> input>=Constant.ANCHOR_POINT;
        RacingCar racingCar = new RacingCar(moveStrategy);
        assertThat(racingCar.allowMove()).isEqualTo(resultBool);
    }

    @DisplayName("자동차의 경주결과 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:3:1,5,6:2", "1:5:1,5,6,0,2:2", "1:4:1,5,6,7:3", "1:4:1,5,6,1:2"}, delimiter = ':')
    public void skidMarkTest(int carNumber, int playCount, String commaString, int resultProgress) {
        List<Integer> numbers = Arrays.stream(commaString.split(",")).map(Integer::parseInt).collect(Collectors.toList());
        Queue<Integer> numberQueue = new LinkedList<>();
        numbers.forEach(numberQueue::offer);
        MoveStrategy moveStrategy = () -> numberQueue.poll() > Constant.ANCHOR_POINT;

        racingGame.execute(new RacingInfomation(carNumber, playCount), moveStrategy);
        List<Integer> integers = racingGame.getResultByRound(playCount).orElseThrow(IllegalArgumentException::new);
        Integer integer = integers.get(0);
        assertThat(integer).isEqualTo(resultProgress);
    }


    @DisplayName("레이싱게임 정보 null 테스트")
    @ParameterizedTest
    @NullSource
    public void nullAndEmptyRacingTest(RacingInfomation input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> racingGame.execute(input, MoveStrategy.defaultStrategy(new Random())))
                .withMessageStartingWith("빈 공백");
    }
}
