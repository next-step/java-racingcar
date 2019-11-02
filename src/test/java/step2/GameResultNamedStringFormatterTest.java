package step2;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step2.domain.CarDistanceGenerator;
import step2.domain.EqualCarDistanceGenerator;
import step2.domain.GameResult;
import step2.domain.GameRunner;
import step2.view.format.GameResultNamedStringFormatter;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("GameResultNameStringFormatter should")
class GameResultNamedStringFormatterTest {
    private GameResult gameResult;

    @BeforeEach
    void before() {
        final String carNames = "pobi,crong,honux";
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
    @DisplayName("return named formatted string")
    void string() {
        final String expected = "" +
                "pobi\t:\t-----\n" +
                "crong\t:\t-----\n" +
                "honux\t:\t-----\n" +
                "\n" +
                "pobi\t:\t----------\n" +
                "crong\t:\t----------\n" +
                "honux\t:\t----------";
        final String formattedGameResult = new GameResultNamedStringFormatter().format(gameResult);

        assertThat(formattedGameResult).isEqualTo(expected);
    }


    @Test
    @DisplayName("return named formatted string in custom delimiter")
    void handleCustomCarSymbol() {
        final String expected = "" +
                "pobi\t:\t.....\n" +
                "crong\t:\t.....\n" +
                "honux\t:\t.....\n" +
                "\n" +
                "pobi\t:\t..........\n" +
                "crong\t:\t..........\n" +
                "honux\t:\t..........";
        final String formattedGameResult = new GameResultNamedStringFormatter(".").format(gameResult);

        assertThat(formattedGameResult).isEqualTo(expected);
    }
}