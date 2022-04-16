package racingcar.play;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.generator.NumberGenerator;


import static org.assertj.core.api.Assertions.assertThat;

class ZeroToNineRandomPolicyTest {

    static final RacingGamePolicy racingGamePolicy = new ZeroToNineRandomPolicy(new NumberGenerator());

    @DisplayName("0-9 랜덤 정책 테스트")
    @ParameterizedTest
    @ValueSource(ints = {5})
    void racing(int tryNumber) {

        for(int i = 0; i < tryNumber; i++ ) {
            int result = racingGamePolicy.racing(10);

            assertThat(result).isGreaterThanOrEqualTo(0).isLessThanOrEqualTo(9);
        }
    }

}