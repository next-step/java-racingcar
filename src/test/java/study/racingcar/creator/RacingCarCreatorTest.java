package study.racingcar.creator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by wyparks2@gmail.com on 2019-06-17
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
class RacingCarCreatorTest {
    @ParameterizedTest
    @CsvSource({
            "1, 1",
            "100, 100",
            "13, 13",
            "0, 0"
    })
    void 차_생성(int count, int expected) {
        assertThat(RacingCarCreator.create(count).size()).isEqualTo(expected);
    }
}