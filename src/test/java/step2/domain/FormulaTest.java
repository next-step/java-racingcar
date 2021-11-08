package step2.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FormulaTest {

    @Test
    void 수식을_생성한다() {
        //given
        String value = "1 + 1";
        //when
        Formula formula = Formula.of(value);
        //then
        assertThat(formula).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "3 +", "3 % 3 + 1"})
    void 수식에_유효하지_않은_값을_입력_하면_IllegalArgumentException_이_발생한다(String formula) {
        //given
        //when & then
        assertThrows(IllegalArgumentException.class,
                () -> Formula.of(formula));
    }
}
