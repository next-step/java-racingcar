package domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingGameTest {
    @Test
    @DisplayName("경주게임 생성 테스트")
    public void racingGameTest() {
        Cars cars = new Cars(
            List.of(
                new Car("pobi", new Position(3)),
                new Car("honux", new Position(4)),
                new Car("brown", new Position(5)),
                new Car("jiny", new Position(5))
            )
        );
        RacingGame racingGame = new RacingGame(cars);
        assertThat(racingGame.size()).isEqualTo(4);
    }
}
