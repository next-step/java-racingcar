package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.GameResults;
import racingcar.domain.RoundResult;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class GameResultsTest {

    GameResults gameResults;

    @BeforeEach
    void setUp() {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("kim", 1);
        map1.put("lee", 1);
        map1.put("cha", 0);
        RoundResult roundResult1 = new RoundResult(map1);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("kim", 1);
        map2.put("lee", 2);
        map2.put("cha", 0);
        RoundResult roundResult2 = new RoundResult(map2);

        gameResults = new GameResults(Arrays.asList(roundResult1, roundResult2));
    }

    @Test
    void findWinners() {
        assertThat(gameResults.findWinners()).isEqualTo(List.of("lee"));
    }
}