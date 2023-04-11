package step3.service;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarForwardMatcherTest {

    @ParameterizedTest
    @CsvSource(value = {"4:true", "5:true", "6:true", "7:true", "8:true", "9:true"}, delimiter = ':')
    void 랜덤값이_4이상이면_전진조건에_해당한다(int random, boolean expected) {
        final GameMatcher matcher = new RacingCarForwardMatcher();

        assertThat(matcher.match(random)).isEqualTo(expected);
    }

}