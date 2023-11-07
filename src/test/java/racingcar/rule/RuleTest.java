package racingcar.rule;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RuleTest {

    @DisplayName("최소값을 입력한다. 검증은 입력한 값이 최소값 이상인 경우에만 성공한다")
    @ParameterizedTest
    @CsvSource(value = {"1:false", "2:false", "3:false", "4:true", "5:true"}, delimiter = ':')
    public void minmum_rule(int input, boolean expected){
        MinimumRule rule = new MinimumRule(4);
        rule.changeValue(input);
        assertThat(rule.verify()).isEqualTo(expected);
    }
}