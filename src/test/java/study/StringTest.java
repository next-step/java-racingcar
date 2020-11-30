package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {

    @Test
    @DisplayName("문자열을 콤마로 분리한다.")
    void split() {
        String inputString = "1,2";
        String[] result = inputString.split(",");
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("괄호안에 문자열을 콤마로 분리한다.")
    void substring() {
        String inputString = "(1,2)";
        String[] result = inputString.substring(inputString.indexOf("(") + 1, inputString.indexOf(")")).split(",");
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    @DisplayName("특정 위치의 문자열이 없으면 IndexOutOfBoundsException을 발생시킨다.")
    void charAt() {
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    int size = 2;
                    int index = 5;
                    String inputString = "abc";
                    try {
                        char result = inputString.charAt(index);
                        assertThat(result).isEqualTo(0);
                    } catch (IndexOutOfBoundsException e) {
                        throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
                    }
                }).withMessageMatching("Index: \\d+, Size: \\d+");
    }

    @Test
    @DisplayName("마이너스 위치의 문자열을 가져올 때 IndexOutOfBoundsException을 발생시킨다.")
    void charAt_minus() {
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    int size = 2;
                    int index = -1;
                    String inputString = "abc";
                    try {
                        char result = inputString.charAt(index);
                        assertThat(result).isEqualTo(0);
                    } catch (IndexOutOfBoundsException e) {
                        throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
                    }
                }).withMessageMatching("Index: -?\\d+, Size: \\d+");
    }

}
