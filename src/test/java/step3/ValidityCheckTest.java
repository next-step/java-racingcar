package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import step3.validite.ValidityCheck;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidityCheckTest {

    @Test
    public void 입력_숫자() {
        //given
        int number = 2;
        //when
        //then
        assertThat(ValidityCheck.positiveNumberCheck(number)).isEqualTo(number);
    }

    @Nested
    @DisplayName("입력값이 숫자가 아닌값 테스트")
    class ValidityCheckFaild {
        @Test
        @DisplayName("null 체크")
        public void 입력_null_또는_빈문자() {
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
            String invalidNumber = "a";
            //when
            //then
            assertThatThrownBy(() -> ValidityCheck.positiveNumberCheck(Integer.parseInt(invalidNumber))).isInstanceOf(NumberFormatException.class);
        }
    }
}
