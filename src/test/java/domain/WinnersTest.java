package domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinnersTest {
    @Test
    @DisplayName("우승자 찾기")
    void getWinner() {
        Car pobi = new Car("pobi", new Position(3));
        Car honux = new Car("honux", new Position(4));
        Car brown = new Car("brown", new Position(5));
        Car jiny = new Car("jiny", new Position(5));
        Cars cars = new Cars(
            List.of(
                pobi, honux, brown, jiny
            )
        );
        RacingGame racingGame = new RacingGame(cars);
        Winners winners = new Winners(racingGame);
        assertAll(
            () -> assertThat(winners.getCars().size()).isEqualTo(2),
            () -> assertThat(winners.getCars()).containsExactlyInAnyOrder(jiny, brown)
        );
    }
}
