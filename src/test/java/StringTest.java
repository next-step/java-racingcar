import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("String 클래스의 ")
public class StringTest {

    @Nested
    @DisplayName("split 메소드를 사용하여  ")
    class SplitTest {

        private final String delimiterComma = ",";

        @Test
        @DisplayName("콤마로 분리된 문자열 1,2 를 콤마를 중심으로 문자열 1과 2로 쪼갠다")
        void givenStringWithComma_whenSplit_thenReturnParts() {
            String strWithComma = "1,2";

            String[] parts = strWithComma.split(delimiterComma);

            Assertions.assertThat(parts).hasSize(2);
            Assertions.assertThat(parts[0]).isEqualTo("1");
            Assertions.assertThat(parts[1]).isEqualTo("2");
        }

        @Test
        @DisplayName("콤마가 존재하지 않는 문자열 1 을 콤마를 중심으로 쪼개려 할 경우 원본 문자열만이 포함된 배열을 리턴한다")
        void givenStringWithoutComma_whenSplit_thenReturnOnePart() {
            String strWithoutComma = "1";

            String[] parts = strWithoutComma.split(delimiterComma);

            Assertions.assertThat(parts).hasSize(1);
            Assertions.assertThat(parts[0]).isEqualTo("1");
        }
    }


}
