package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;

class RuleTest {

    LinkedHashMap<Name, Position> sortedmap;
    Map<Name, Position> map = new HashMap<>();
    TreeSet<Name> winner;

    private static final int CAR_NUM = 4;

    @BeforeEach
    void setUp() {
        for (int i = 1; i <= CAR_NUM; i++) {
            map.put(new Name("name" + i), new Position(i));
        }

    }

    @Test
    void sortWinnerTest() {
        sortedmap = Rule.sortWinner(map);
        assertThat(sortedmap.size()).isEqualTo(CAR_NUM);
        int index = CAR_NUM;
        for (Map.Entry<Name, Position> entry : sortedmap.entrySet()) {
            assertThat(entry.getKey()).isEqualTo(new Name("name" + index));
            assertThat(entry.getValue()).isEqualTo(new Position(index));
            index--;
        }
    }

    @Test
    void whoIsWinnerTest() {
        Name winnerName = new Name("win");
        map.put(winnerName, new Position(CAR_NUM));
        winner = Rule.whoIsWinner(map);
        assertThat(winner.size()).isEqualTo(2);
        assertThat(winner.contains(new Name("name" + CAR_NUM))).isTrue();
        assertThat(winner.contains(winnerName)).isTrue();
    }

}
