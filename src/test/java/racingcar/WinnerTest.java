package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerTest {

    @DisplayName("우승자의 수는 1명을 초과할 수 있다")
    @ParameterizedTest(name = "매 라운드 이동했는가: {0}")
    @ValueSource(strings =  {"true", "false"})
    void numberOfWinnerCanBeMoreThan2(Boolean movable) {
        Race race = new Race(Arrays.asList("Kevin","Bob","Dave"), 5, () -> movable);
        race.doRace();
        Winners winner = new Winners(race);
        assertThat(winner.getWinners().size()).isGreaterThan(1);
    }
}
