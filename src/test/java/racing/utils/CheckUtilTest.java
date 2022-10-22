package racing.utils;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

class CheckUtilTest {

    @Test
    void Null_체크() {
        assertThat(CheckUtil.isNull(" ")).isTrue();
    }

    @Nested
    class NumberCheck {

        @Test
        void 숫자_체크() {
            assertThat(CheckUtil.isNumber("d")).isFalse();
            assertThat(CheckUtil.isNumber("2")).isTrue();
            assertThat(CheckUtil.isNumber("-2")).isTrue();
            assertThat(CheckUtil.isNumber("+2")).isTrue();
        }

        @Test
        void 양수_String_체크() {
            assertThat(CheckUtil.isPositive("2")).isTrue();
            assertThat(CheckUtil.isPositive("-2")).isFalse();
        }

        @Test
        void 양수_int_체크() {
            assertThat(CheckUtil.isPositive(2)).isTrue();
            assertThat(CheckUtil.isPositive(-2)).isFalse();
        }

        @Test
        void 양수_종합_체크() {
            assertThat(CheckUtil.checkPositive("d")).isFalse();
            assertThat(CheckUtil.checkPositive("2")).isTrue();
            assertThat(CheckUtil.checkPositive("-2")).isFalse();
        }
    }

    @Nested
    class StrToArray {
        @Test
        void 문자열_배열_체크() {

            String[] arr = SplitUtil.strToArray("자동차1,자동차2");
            assertThat(CheckUtil.checkStrArray(arr)).isTrue();
        }

        @Test
        void 문자열_배열_Null_체크() {
            String[] arr = SplitUtil.strToArray("자동차1,,자동차2");
            assertThat(CheckUtil.checkStrArray(arr)).isFalse();
        }

        @Test
        void 문자열_배열_변환_체크() {
            assertThat(CheckUtil.checkStrToArray("자동차1,자동차2")).isTrue();
            assertThat(CheckUtil.checkStrToArray("자동차1,,자동차2")).isFalse();
        }
    }
}