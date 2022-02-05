package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class RacingResultTest {

    @Test
    void 승자들을_내부에_등록할_수_있다() {
        List<String> winners = new ArrayList<>(Arrays.asList("tdd", "race", "lotto"));
        RacingResult racingResult = RacingResult.instance();

        racingResult.registerWinners(winners);
        List<String> result = racingResult.getResult();

        assertThat(result.size()).isEqualTo(winners.size());
        assertThat(result).containsExactly("tdd", "race", "lotto");
    }

}
