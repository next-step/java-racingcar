package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidityCheckTest {

    @Test
    public void 입력_숫자() {
        //given
        int number = 2;
        //when
        //then
        assertThat(ValidityCheck.positiveNumberCheck(number)).isTrue();
    }

    @Nested
    @DisplayName("입력값이 숫자가 아닌값 테스트")
    class ValidityCheckFaild{
        @ParameterizedTest
        @NullAndEmptySource
        @DisplayName("null, 빈문자열 체크")
        public void 입력_null_또는_빈문자(int number) {
            //given
            //when
            //then
            assertThatThrownBy(() -> ValidityCheck.positiveNumberCheck(null)).isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        public void 입력_음수() {
            //given
            //when
            //then
            assertThatThrownBy(() -> ValidityCheck.positiveNumberCheck(-1)).isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        public void 입력_문자() {
            //given
            //when
            //then
            assertThatThrownBy(() -> ValidityCheck.positiveNumberCheck("a")).isInstanceOf(IllegalArgumentException.class);
        }
    }
}
