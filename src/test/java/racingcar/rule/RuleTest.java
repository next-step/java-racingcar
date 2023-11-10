package racingcar.rule;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.util.BasicNumberGenerator;

import static org.assertj.core.api.Assertions.assertThat;

class RuleTest {

    @ParameterizedTest(name = "최소값을 입력한다. 검증은 입력한 값이 최소값 이상인 경우에만 성공한다")
    @CsvSource(value = {"3:false", "4:true"}, delimiter = ':')
    public void minimum_rule(int input, boolean expected) {
        MinimumRule rule = new MinimumRule(4, new BasicNumberGenerator(input));
        assertThat(rule.verify()).isEqualTo(expected);
    }
}