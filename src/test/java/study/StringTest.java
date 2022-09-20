package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class StringTest {

    @DisplayName("요구사항1 - 1,2을 split을 했을 시, 1과 2로 잘 분리한다.")
    @Test
    void manyStringSplitTest() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @DisplayName("요구사항1 - 1을 split했을 때 1만 포함한 배열을 반환한다.")
    @Test
    void singleStringSplitTest() {
        String[] result = "1".split(",");
        assertThat(result).contains("1");
    }

    @DisplayName("요구사항2 - (1,2)가 주어졌을 때, ()을 제거하고 1,2을 반환한다.")
    @Test
    void substringTest() {
        String result = "(1,2)".substring(1,4);
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("요구사항3 - abc 값이 주어졌을때 String의 charAt() 메소드로 인덱스에 해당하는 값 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"0,a", "1,b", "2,c"}, delimiter = ',')
    void chartAtTest(int index, char extract) {
        char result = "abc".charAt(index);
        assertThat(result).isEqualTo(extract);
    }

    @DisplayName("요구사항3 - 정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 3})
    void chartAtOfStringIndexOutOfBoundsException(int index) {
        assertThatThrownBy(() -> {
            "abc".charAt(index);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
            .hasMessageContaining("String index out of range: "+index);
    }

}
