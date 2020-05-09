package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    @DisplayName("문자열을 분할하고 배열의 값이 포함됐는지 검증한다.")
    void splitTest() {
        String data = "1,2";
        String regex = ",";

        String[] result = data.split(regex);

        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("문자열을 추출하고 값이 일치하는지 검증한다.")
    void substringTest() {
        String data = "(1,2)";
        String expected = "1,2";

        String result = data.substring(1, data.length()-1);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("인덱스를 통해 문자열의 문자를 추출하여 값을 검증하고, 인덱스 범위가 벗어날 경우 예외가 일치하는지 검증한다.")
    public void charAtTest(){
        String data = "abc";
        int index = 0;
        char expected = 'a';
        int outOfIndex = data.length() + 1;

        char result = data.charAt(index);

        assertThat(result).isEqualTo(expected);
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> data.charAt(outOfIndex));
    }
}
