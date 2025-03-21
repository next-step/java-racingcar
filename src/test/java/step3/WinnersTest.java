package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.game.Car;
import step3.game.GameRound;
import step3.game.Winners;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnersTest {
    @Test
    @DisplayName("우승자를 출력하는지 확인한다.")
    void printWinnersTest() {
        List<GameRound> result = new ArrayList<>();
        result.add(new GameRound(List.of(
                new Car("a", 1),
                new Car("b", 2),
                new Car("c", 3)
        )));

        // when
        List<String> actual = Winners.findWinners(result);

        // then
        assertThat(actual.size()).isEqualTo(1);
        assertThat(actual).isEqualTo(List.of("c"));
    }
}
