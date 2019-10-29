package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("GameResultStringFormatter should")
class GameResultStringFormatterTest {
    private GameResult gameResult;

    @BeforeEach
    void before() {
        final int tryTimes = 2;
        final int numberOfCars = 4;
        final CarDistanceGenerator generator = new EqualCarDistanceGenerator(5);

        gameResult = new GameRunner(tryTimes, numberOfCars, generator).simulate();
    }

    @Test
    @DisplayName("return formatted string")
    void string() {
        final String expected = "" +
                "-----\n" +
                "-----\n" +
                "-----\n" +
                "-----\n" +
                "\n" +
                "----------\n" +
                "----------\n" +
                "----------\n" +
                "----------";
        final String formattedGameResult = new GameResultStringFormatter().format(gameResult);

        assertThat(formattedGameResult).isEqualTo(expected);
    }


    @Test
    @DisplayName("return formatted string in custom delimiter")
    void handleCustomCarSymbol() {
        final String expected = "" +
                ".....\n" +
                ".....\n" +
                ".....\n" +
                ".....\n" +
                "\n" +
                "..........\n" +
                "..........\n" +
                "..........\n" +
                "..........";
        final String formattedGameResult = new GameResultStringFormatter(".").format(gameResult);

        assertThat(formattedGameResult).isEqualTo(expected);
    }
}