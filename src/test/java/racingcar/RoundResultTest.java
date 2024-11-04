package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.RoundResult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class RoundResultTest {

    @Test
    void findWinners() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Kim", 3);
        map.put("Lee", 5);
        map.put("Cha", 1);
        RoundResult roundResult = new RoundResult(map);

        assertThat(roundResult.findWinners()).isEqualTo(List.of("Lee"));
    }
}