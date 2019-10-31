package step2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step2.domain.Car;
import step2.domain.GameResult;
import step2.domain.Location;
import step2.view.format.GameResultNamedWinnerStringFormatter;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("GameResultNamedWinnerStringFormatter should")
class GameResultNamedWinnerStringFormatterTest {
    private GameResult gameResult;

    @BeforeEach
    void before() {
        final int tryTimes = 1;
        final int numberOfCars = 3;
        final List<Car> carsAt1 = Stream.of(5, 10, 2)
                                        .map(i -> new Car(String.format("len%s", i), Location.of(i)))
                                        .collect(Collectors.toList());
        final Map<Integer, GameResult.Phase> phaseMap = new HashMap<>();
        phaseMap.put(0, new GameResult.Phase(0, carsAt1));

        gameResult = new GameResult(tryTimes, numberOfCars, phaseMap);
    }

    @Test
    @DisplayName("return named winner formatted string")
    void string() {
        final String expected = "" +
                "len5\t:\t-----\n" +
                "len10\t:\t----------\n" +
                "len2\t:\t--\n" +
                "\n" +
                "len10 이(가) 최종 우승했습니다.";
        final String formattedGameResult = new GameResultNamedWinnerStringFormatter().format(gameResult);

        assertThat(formattedGameResult).isEqualTo(expected);
    }


    @Test
    @DisplayName("return named winner formatted string in custom delimiter")
    void handleCustomCarSymbol() {
        final String expected = "" +
                "len5\t:\t.....\n" +
                "len10\t:\t..........\n" +
                "len2\t:\t..\n" +
                "\n" +
                "len10 이(가) 최종 우승했습니다.";
        final String formattedGameResult = new GameResultNamedWinnerStringFormatter(".").format(gameResult);

        assertThat(formattedGameResult).isEqualTo(expected);
    }

}