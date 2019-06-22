package study.racingcar.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by wyparks2@gmail.com on 2019-06-22
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
class RacingGameInfoTest {

    @Test
    void 차이름_중복불가() {
        RacingGameInfo racingGameInfo = new RacingGameInfo(
                new HashSet<>(Arrays.asList("car1", "car1", "car2")), 5);

        assertThat(racingGameInfo.getCarNames()).containsExactly("car2", "car1");
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6})
    void moveCarTryLimit(int input) {
        RacingGameInfo racingGameInfo = new RacingGameInfo(
                new HashSet<>(Arrays.asList("car1", "car2")), input);

        assertThat(racingGameInfo.getMoveCarTryLimit()).isEqualTo(input);
    }
}
