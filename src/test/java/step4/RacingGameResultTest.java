package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameResultTest {

    @DisplayName("Game Result 생성 테스트")
    @Test
    void getWinnersWhenCarsAlwaysMove() {
        Cars cars = Cars.of(() -> 5, List.of("a", "b", "c"));
        for (int i = 0; i < 3; i++) cars.move();

        RacingGameResult result = RacingGameResult.makeResult(cars);
        assertThat(result.getWinners())
                .hasSize(3);
        assertThat(result.getWinners())
                .containsExactly("a", "b", "c");
    }
}