package step3.models;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class GameTest {
    @Test
    void Given_Numbers_When_PlayGame_Then_Equals_ResultSize() {
        int carNumber = 3;
        int tryNumber = 5;
        Game game = new Game(carNumber, tryNumber);

        List<List<Car>> results = game.play();

        assertThat(results.size()).isEqualTo(tryNumber);
        results.forEach(result -> assertThat(result.size()).isEqualTo(carNumber));
    }
}
