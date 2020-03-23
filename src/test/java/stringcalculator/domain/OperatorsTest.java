package stringcalculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OperatorsTest {

    @DisplayName("Operators 객체 생성 테스트")
    @Test
    public void newOperatorsInstanceTest() {
        //given
        String source = "2 + 3 * 4 / 2";

        //when
        Operators Operators = new Operators(source.split(Constant.BLANK));

        //then
        assertThat(Operators).isNotNull();
    }

    @DisplayName("Operators 자료구조 테스트 : 먼저 넣은 값은 먼저 나온다")
    @Test
    public void OperatorsCollectionHasNextTrueTest() {
        //given
        String source = "2 + 3 * 4";

        //when
        String[] splitValue = source.split(Constant.BLANK);
        Operators Operators = new Operators(splitValue);

        //then
        assertThat(Operators.get()).isEqualTo("+");
        assertThat(Operators.get()).isEqualTo("*");
    }

}
