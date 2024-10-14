package step1testpractice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringClassTest {
    private final String require2NumberData = "(1,2)";
    private final String require2abcData = "abc";
    private final String numbersData = "1,2";
    private final String numberData = "1";

    @Test
    @DisplayName(value = "1,2 split으로 분리여부 확인 테스트")
    public void splitNumbersTest() {
        assertThat(numbersData.split(",")).contains("1", "2");
    }

    @Test
    @DisplayName(value = "1 split후 1만 포함하는지 확인 테스트")
    public void splitNumberTest() {
        assertThat(numberData.split(",")).containsExactlyInAnyOrder("1");
    }

    @Test
    @DisplayName(value = "(1,2) subString사용해서 1,2만 반환 테스트")
    public void shouldReturnNumberTest() {
        assertThat(require2NumberData.substring(1, 4)).isEqualTo("1,2");
    }

    @Test
    @DisplayName(value = "abc에서 특정위치 문자 가져오는 테스트")
    public void getCharFromStringDataTest() {
        assertThat(require2abcData.charAt(0)).isEqualTo('a');
    }

    @Test
    @DisplayName(value = "abc 데이터 indexOutOfBoundsException 발생 테스트")
    public void makeOutOfBOundsExceptionFromCharAtTest() {
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    require2abcData.charAt(4);
                });
    }

}

