package calculator.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class ExpressionTest {

    @DisplayName("계산식 null 또는 empty 전달시 에러")
    @ParameterizedTest
    @NullAndEmptySource
    public void notNullOrEmpty(String source) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> Expression.execute(source));

    }

}
