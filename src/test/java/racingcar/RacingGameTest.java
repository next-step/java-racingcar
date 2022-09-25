package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    private static final Positive CAR_QUANTITY = new Positive(3);
    private static final Positive MOVEMENT_COUNT = new Positive(4);

    private Input input;

    @BeforeEach
    void setDate() {
        input = new FakeInput(CAR_QUANTITY, MOVEMENT_COUNT);
    }

    @Test
    @DisplayName("ready(Input input) 메소드를 사용하면 생성된 RacingGame 인스턴스의 carQuantity와 movementCount가 초기화 된다.")
    void ready() {
        RacingGame expected = RacingGame.ready(CAR_QUANTITY, MOVEMENT_COUNT);

        RacingGame actual = RacingGame.ready(input);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("start() 메소드가 실행되면 cars의 상태가 변경되어 인스턴스 동등성 비교가 실패한다.")
    void start() {
        RacingGame readyGame = RacingGame.ready(input);
        RacingGame expected = RacingGame.ready(input);

        RacingGame startedGame = readyGame.start();

        assertThat(startedGame).isNotEqualTo(expected);
    }
}
