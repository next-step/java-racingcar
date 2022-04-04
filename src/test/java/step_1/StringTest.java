package step_1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    @DisplayName("요구사항 1")
    void spilt() {
        // given
        String arg = "1,2";

        // when
        String[] splitArr = arg.split(",");

        // then
        // 요구사항 1-1 > "1,2"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
        // containsExactly() : 대상이 되는 Iterable 혹은 배열에 인자로 받는 값이 순서대로 일치하게 포함되어 있는지 확인한다.
        assertThat(splitArr).containsExactly("1", "2");
        // containsExactlyElementsOf() : 대상이 되는 Iterable 혹은 배열에 인자로 받는 Iterable 객체의 요소의 순서와 값이 정확히 일치하게 포함되어 있는지 확인한다.
        assertThat(splitArr).containsExactlyElementsOf(Arrays.asList(splitArr));

        // 요구사항 1-2 > "1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.
        // contains() : 대상이 되는 Iterable 혹은 배열에 인자로 받는 값이 순서와 관계없이 포함되어 있는지 확인한다.
        assertThat(splitArr).contains("1");
    }

    @Test
    @DisplayName("요구사항 2")
    void subString() {
        // given
        String arg = "(1,2)";

        // when
        String subStringArgs = arg.substring(1, arg.length() - 1);

        // then
        assertThat(subStringArgs).isEqualTo("1,2");
    }

    @ParameterizedTest
    // delimiter 인자를 기준으로 value 의 각 요소를 나누어 해당 테스트 메소드의 파라미터 인자로 주입한다.¬
    @CsvSource(value = {"0:a", "1:b", "2:c"}, delimiter = ':')
    @DisplayName("요구사항 3-1 > \"abc\" 값이 주어졌을 때 String 의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.")
    void charAt(int index, char value) {
        // given
        String arg = "abc";

        // when / then
        // [0] 0, a
        // [1] 1, b
        // [2] 2, c
        assertThat(arg.charAt(index)).isEqualTo(value);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 3})
    @DisplayName("요구사항 3-2 > String 의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException 이 발생하는 부분에 대한 학습 테스트를 구현한다.")
    void exceptionOfType(int outOfBoundIndex) {
        // given
        String arg = "abc";

        // when / then
        // assertThatThrownBy()
        assertThatThrownBy(() -> arg.charAt(outOfBoundIndex))
                .isExactlyInstanceOf(StringIndexOutOfBoundsException.class);
        // assertThatExceptionOfType()
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> arg.charAt(outOfBoundIndex));
    }
}
