package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class FormulasTest {

    @DisplayName("생성자에서 정상적으로 split 되는지 확인")
    @Test
    void create() {
        Formulas formulas = new Formulas("2 + 3 * 4");
        assertThat(formulas.getFormulas().length).isEqualTo(5);
    }

    @DisplayName("문자열 수식 값이 null일 경우 IllegalArgumentException 발생")
    @ParameterizedTest(name = "{index} {displayName}")
    @NullAndEmptySource
    void create_ThrowsIllegalArgumentException_IfFormulasIsNull(String formulas) {
        System.out.println(formulas);
        assertThatIllegalArgumentException().isThrownBy(
                () -> new Formulas(formulas)
        );
    }
}
