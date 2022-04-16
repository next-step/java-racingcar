package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class NextStepRuleTest {

    private final MovementRule nextStepRule = new NextStepRule();

    @ParameterizedTest
    @CsvSource(
            value = {"1:false", "2:false", "3:false", "4:true", "5:true", "6:true", "7:true", "8:true", "9:true"},
            delimiter = ':'
    )
    @DisplayName("숫자 4이상이면 움직이는 규칙을 만족한다")
    void meetsNextStepRule(int number, boolean expected) {
        //when
        boolean meetsRule = nextStepRule.meetsRule(number);

        //then
        assertThat(meetsRule).isEqualTo(expected);
    }
}