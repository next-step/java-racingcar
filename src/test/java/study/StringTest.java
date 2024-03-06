package study;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @DisplayName("요구사항 1 - string이 잘 split 되는지 확인한다.")
    @Test
    void checkSplitString() {

        String sut = "1,2";
        String[] result = sut.split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @DisplayName("요구사항 2 - string이 잘 잘리는지 확인한다.")
    @Test
    void checkSubString() {

        String sut = "(1,2)";
        String result = sut.substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("요구사항 3-1 - 특정 위치의 문자를 잘 가져오는지 확인한다.")
    @ParameterizedTest
    @CsvSource(value = {"0,a", "1,b", "2,c"})
    void checkCharAt(int index, char solution) {

        String sut = "abc";
        char result = sut.charAt(index);
        assertThat(result).isEqualTo(solution);
    }

    @DisplayName("요구사항 3-2 - 문자열 위치 범위를 벗어나면 Exception이 발생되는지 확인한다.")
    @Test
    void checkIndexOutOfBoundsException() {

        String sut = "abc";
        int index = 4;
        assertThatThrownBy(() -> {
            sut.charAt(index);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: " + index);
    }
}
