package racingcar.racingGame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Input;
import racingcar.RacingGame;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    public static final int CAR_QUANTITY = 3;
    public static final int MOVEMENT_COUNT = 4;

    @Test
    @DisplayName("ready(Input input) 메소드를 사용하면 생성된 RacingGame 인스턴스의 carQuantity와 movementCount가 초기화 된다.")
    void ready() {
        Input input = new FakeInput(CAR_QUANTITY, MOVEMENT_COUNT);
        RacingGame expected = RacingGame.ready(CAR_QUANTITY, MOVEMENT_COUNT);

        RacingGame actual = RacingGame.ready(input);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("start() 메소드가 실행되면 cars의 상태가 변경되어 인스턴스 동등성 비교가 실패한다.")
    void start() {
        Input input = new FakeInput(CAR_QUANTITY, MOVEMENT_COUNT);
        RacingGame readyGame = RacingGame.ready(input);
        RacingGame expected = RacingGame.ready(input);

        RacingGame startedGame = readyGame.start();

        assertThat(startedGame).isNotEqualTo(expected);
    }
}
