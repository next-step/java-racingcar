package step4.racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;

class RuleTest {

    LinkedHashMap<String, Integer> sortedmap;
    Map<String, Integer> map = new HashMap<>();
    TreeSet<String> winner;

    private static final int CAR_NUM = 4;

    @BeforeEach
    void setUp() {
        for (int i = 1; i <= CAR_NUM; i++) {
            map.put("name" + i, i);
        }

    }

    @Test
    void sortWinnerTest() {
        sortedmap = Rule.sortWinner(map);
        assertThat(sortedmap.size()).isEqualTo(CAR_NUM);
        int index = CAR_NUM;
        for (Map.Entry<String, Integer> entry : sortedmap.entrySet()) {
            assertThat(entry.getKey()).isEqualTo("name" + index);
            assertThat(entry.getValue()).isEqualTo(index);
            index--;
        }
    }

    @Test
    void whoIsWinnerTest() {
        String winnerName = "sameWinner";
        map.put(winnerName, CAR_NUM);
        winner = Rule.whoIsWinner(map);
        assertThat(winner.size()).isEqualTo(2);
        assertThat(winner.contains("name" + CAR_NUM)).isTrue();
        assertThat(winner.contains(winnerName)).isTrue();
    }

}
