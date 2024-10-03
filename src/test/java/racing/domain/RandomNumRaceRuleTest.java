package racing.domain;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumRaceRuleTest {

    private static final RandomNumRaceRule raceRule = new RandomNumRaceRule();

    @Test
    void 랜덤_테스트() {
        List<Boolean> results = IntStream.range(0, 100)
                .mapToObj(i -> raceRule.isForward())
                .collect(Collectors.toList());

        assertThat(results).contains(true, false);
    }
}
