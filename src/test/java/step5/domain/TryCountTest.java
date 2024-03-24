package step5.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class TryCountTest {

    @DisplayName("zeroOrLessThanZero는 0이하의 숫자를 가지고 있는지 검사한다.")
    @ParameterizedTest
    @CsvSource(value = {"1,false", "0,true", "-1,true"})
    void zeroOrLessThanZero(int input, boolean expectResult) {
        assertThat(new TryCount(input).zeroOrLessThanZero())
                .isEqualTo(expectResult);
    }

}
