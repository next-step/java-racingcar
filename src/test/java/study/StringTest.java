package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

@DisplayName("String 클래스에 대한 학습 테스트")
class StringTest {

    private static final String DELIMITER = ",";

    @DisplayName("요구사항 1-1: '1,2'를 ','로 split 했을 때 1과 2를 포함한 배열이 반환된다.")
    @Test
    void split1() {
        String[] result = "1,2".split(DELIMITER);
        assertThat(result).containsExactly("1", "2");
    }

    @DisplayName("요구사항 1-2: '1'을 ','로 split 했을 때 1만을 포함하는 배열이 반환된다.")
    @Test
    void split2() {
        String[] result = "1".split(DELIMITER);
        assertThat(result).containsExactly("1");
    }

    @DisplayName("요구사항 2: '(1,2)'를 substring() 메서드로 괄호를 제거하면 '1,2'가 반환된다.")
    @Test
    void substring() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("요구사항 3-1: 특정 문자열에서 charAt() 메서드로 특정 위치의 문자를 가져올 수 있다.")
    @Test
    void charAt1() {
        char firstCharacter = "abc".charAt(0);
        assertThat(firstCharacter).isEqualTo('a');
    }

    @DisplayName("요구사항 3-2: charAt() 메서드의 인자가 주어진 문자열의 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생한다.")
    @Test
    void charAt2() {
        int index = 3;
        assertThatThrownBy(() -> "abc".charAt(index))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessage("String index out of range: " + index);
    }

}
