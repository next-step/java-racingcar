package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class StringTest {

    @DisplayName("요구사항1: 1,2를 ,로 split하면 1과 2로 분리된다.")
    @Test
    public void testSplitStringByCommaContains() {
        String testStr = "1,2";

        assertThat(splitStringByComma(testStr)).contains("1");
        assertThat(splitStringByComma(testStr)).contains("2");
    }

    @DisplayName("요구사항1: 1를 split하면 1만을 포함하는 배열로 반환한다.")
    @Test
    public void testSplitStringByCommaExactly() {
        String testStr = "1";

        assertThat(splitStringByComma(testStr)).containsExactly("1");
    }

    @DisplayName("요구사항2: (1,2)는 1,2로 반환한다.")
    @Test
    public void testSubtractFirstAndLastString() {
        String testStr = "(1,2)";

        assertThat(subtractFirstAndLastString(testStr)).isEqualTo("1,2");
    }

    @DisplayName("요구사항3: charAt()을 활용하여 특정위치의 문자를 가져온다")
    @Test
    public void testGetStringAt() {
        String testStr = "abc";
        int getStringIndex = 1;
        String expectedValue = "b";

        assertThat(getStringAt(testStr, getStringIndex)).isEqualTo(expectedValue);
    }

    @DisplayName("요구사항3: charAt()의 문자열 범위밖 지정시 StringIndexOutOfBoundsException 발생한다.")
    @Test
    public void testGetStringAtWithStringIndexOutOfBoundsException() {
        String testStr = "abc";
        int getStringIndex = 3;

        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> getStringAt(testStr, getStringIndex))
                .withMessageMatching("String index out of range: 3");
    }

    private String[] splitStringByComma(String inputStr) {
        return inputStr != null ? inputStr.split(",") : new String[0];
    }

    private String subtractFirstAndLastString(String inputStr) {
        return inputStr != null ? inputStr.substring(1, inputStr.length() - 1) : "";
    }

    private String getStringAt(String inputStr, int index) {
        return inputStr != null ? String.valueOf(inputStr.charAt(index)) : "";
    }
}
