package racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.common.RacingValidator;

class RacingValidatorTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 4, 10})
    void isInCarCountRangeTrueTest(int carCount) {
        Assertions.assertThat(RacingValidator.isInCarCountRange(carCount)).isTrue();
    }
    
    @ParameterizedTest
    @ValueSource(ints = {0, 11})
    void isInCarCountRangeFalseTest(int carCount) {
        Assertions.assertThat(RacingValidator.isInCarCountRange(carCount)).isFalse();
    }
    
    @ParameterizedTest
    @ValueSource(ints = {1, 20, 50})
    void isInTimeRangeTrueTest(int timeCount) {
        Assertions.assertThat(RacingValidator.isInTimeRange(timeCount)).isTrue();
    }
    
    @ParameterizedTest
    @ValueSource(ints = {0, 51})
    void isInTimeCountRangeFalseTest(int timeCount) {
        Assertions.assertThat(RacingValidator.isInTimeRange(timeCount)).isFalse();
    }
    
    @ParameterizedTest
    @ValueSource(strings = {"aa", "aa,bb"})
    void isValidCarNamesTrueTest(String carNames) {
        Assertions.assertThat(RacingValidator.isValidCarNames(carNames)).isTrue();
    }
    
    @ParameterizedTest
    @ValueSource(strings = {"", "a,b,c,d,e,f,g,h,i,j,k,l,m,n"})
    void isValidCarNamesFalseTest(String carNames) {
        Assertions.assertThat(RacingValidator.isValidCarNames(carNames)).isFalse();
        Assertions.assertThat(RacingValidator.isValidCarNames(null)).isFalse();
    }
}
