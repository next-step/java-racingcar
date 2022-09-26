package step3.models;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @ParameterizedTest
    @CsvSource(value = {
            "-1, -1",
            "-1, 1",
            "1, -1"
    })
    void Given_NegativeNumber_When_CreateGame_Then_ThrowError(int carNumber, int tryNumber) {
        assertThatThrownBy(() -> new Game(carNumber, tryNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Game.CREATE_ERROR_MSG);
    }
}
