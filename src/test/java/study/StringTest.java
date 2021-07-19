package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

class StringTest {

    @DisplayName("1,2을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트")
    @Test
    void split() {
        String[] array1 = "1,2".split(",");
        String[] array2 = "1".split(",");

        assertThat(array1).contains("1", "2");
        assertThat(array2).containsExactly("1");
    }

    @DisplayName("\"(1,2)\" 값이 주어졌을 때 String 의 substring() 메소드를 활용해 ()을 제거")
    @Test
    void substring() {
        String str = "(1,2)";
        String result = str.substring(1, str.length() - 1);

        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("\"abc\" 값이 주어졌을 때 String 의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트")
    @Test
    void charAt() {
        String str = "abc";

        assertThat(str.charAt(0)).isEqualTo('a');
        assertThat(str.charAt(1)).isEqualTo('b');
        assertThat(str.charAt(2)).isEqualTo('c');
    }

    @DisplayName("String 의 charAt 메서드가 위치 값을 벗어나면 StringIndexOutOfBoundsException 이 발생하는 부분에 대한 학습 테스트")
    @Test
    void outOfBoundsException() {
        String str = "IndexOutOfBounds";
        int index = 33;
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> str.charAt(index)).withMessage("String index out of range: " + index);
    }
}
