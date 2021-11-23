import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    @DisplayName("1,2을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인")
    void splitStringContainsOnlyOriginalValue() {
        String[] result = "1,2".split(",");
        assertThat(result).containsOnly("1", "2");
    }

    @Test
    @DisplayName("1을 ,로 split 했을 때 1만을 포함하는 배열이 반환 확인")
    void splitStringContainsExactlyOriginalValue() {
        String[] result = "1".split(",");
        assertThat(result).containsExactly("1");
    }

    @Test
    @DisplayName("substring() 메소드를 활용해 () 제거")
    void splitStringRemoveBracket() {
        String compare = "(1,2)";
        String result = compare.substring(1, compare.length()-1);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt() 메소드를 활용해 특정 위치의 문자 가져오기")
    void getSpecificCharUsingCharAt() {
        char result = "abc".charAt(0);
        assertThat(result).isEqualTo('a');
    }

    @Test
    @DisplayName("특정 위치의 문자를 가져올 때 위치 값이 벗어나는 경우를 테스트")
    void getSpecificCharUsingCharAtOutOfRange() {
        assertThatThrownBy(() -> { "abc".charAt(5); })
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }

}
