package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    void 요구사항1_split시_1과2분리_확인() {
        String givenString = "1,2";

        String[] split = givenString.split(",");

        assertThat(split).contains("1", "2");
    }

    @Test
    void 요구사항1_split시_1만_포함하느배열_확인() {
        String givenString = "1";

        String[] split = givenString.split(",");

        assertThat(split).containsExactly("1");
    }

    @Test
    void 요구사항2_소괄호_제거여부_확인() {
        String givenString = "(1,2)";

        String subString = givenString.substring(1, 3);

        assertThat(subString).isEqualTo("1,2");
    }

    @Test
    @DisplayName("특정문자 위치값을 벗어나는 경우 에러가 발생하는지 확인한다.")
    void 요구사항3_특정문자_위치값을_벗어나는경우_에러발생() {
        String givenString = "abc";
        int givenIndex = 5;

        assertThatThrownBy(() -> charAt(givenString, givenIndex))
            .isInstanceOf(StringIndexOutOfBoundsException.class)
            .hasMessage("String index out of range: %d", givenIndex);
    }

    private char charAt(String string, int index) {
        return string.charAt(index);
    }
}
