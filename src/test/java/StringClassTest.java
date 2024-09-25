import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringClassTest {

    @Nested
    @DisplayName("첫번째 요구사항 클래스")
    class NumberTest {
          private String NumbersData = "1,2";
          private String NumberData = "1";
          private String [] array;

        @Test
        @DisplayName(value = "1,2 split으로 분리여부 확인 테스트")
        public void splitNumbersTest() {
            array = NumbersData.split(",");
            assertThat(array).contains("1","2");
        }

        @Test
        @DisplayName(value = "1 split후 1만 포함하는지 확인 테스트")
        public void splitNumberTest() {
            array = NumberData.split(",");
            assertThat(array).containsExactlyInAnyOrder("1");
        }

    }

    @Nested
    @DisplayName("두번째 요구사항 클래스")
    class UseSubStringTest {
        private String require2NumberData = "(1,2)";

        @Test
        @DisplayName(value = "(1,2) subString사용해서 1,2만 반환 테스트")
        public void shouldReturnNumberTest() {
            String result = require2NumberData.substring(1,4);
            assertThat("1,2").isEqualTo(result);
        }

    }

    @Nested
    @DisplayName("세번째 요구사항 클래스")
    class StringDataTest {
        private String require2abcData = "abc";

        @Test
        @DisplayName(value = "abc에서 특정위치 문자 가져오는 테스트")
        public void getCharFromStringDataTest() {
            char result = require2abcData.charAt(0);
            assertThat('a').isEqualTo(result);
        }

        @Test
        @DisplayName(value = "abc 데이터 indexOutOfBoundsException 발생 테스트")
        public void makeOutOfBOundsExceptionFromCharAtTest() {
            assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                    .isThrownBy(() ->{
                        require2abcData.charAt(4);
                    });
        }
    }
}

