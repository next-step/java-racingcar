package step2;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step2.domain.CarDistanceGenerator;
import step2.domain.EqualCarDistanceGenerator;
import step2.domain.GameResult;
import step2.domain.GameRunner;
import step2.view.format.GameResultStringFormatter;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("GameResultStringFormatter should")
class GameResultStringFormatterTest {
    private GameResult gameResult;

    @BeforeEach
    void before() {
        final String carNames = "pobi,crong,honux,me";
        final int tryTimes = 2;
        final CarDistanceGenerator generator = new EqualCarDistanceGenerator(5);

        gameResult = GameRunner.builder()
                               .carNames(Arrays.asList(carNames.split(",")))
                               .tryTimes(tryTimes)
                               .carDistanceGenerator(generator)
                               .build()
                               .simulate();
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