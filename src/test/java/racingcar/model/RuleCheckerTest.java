package racingcar.model;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RuleCheckerTest {

    @Test
    @DisplayName("넥스트 스텝 이동 규칙 만족 여부를 전달한다")
    void checkRuleTest() {
        //given
        RuleChecker ruleChecker = new RuleChecker(new NextStepRule());
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

        //when
        List<Boolean> movableList = ruleChecker.checkRule(numbers);

        //then
        assertThat(movableList).containsExactly(false, false, false, true, true, true, true, true, true);
    }

}