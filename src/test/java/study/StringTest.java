package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("String 학습 테스트")
public class StringTest {

    @Test
    public void split1() {
        // "1,2"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
        assertThat("1,2".split(",")).contains("1", "2")      // 포함 여부만 확인하기
                .containsExactly("1", "2");                         // 순서까지 확인하기
    }

    @Test
    void split2() {
        // "1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.
        assertThat("1".split(",")).containsOnly("1")         // 1만 포함하는지 확인
                .isExactlyInstanceOf(String[].class);               // String 배열인지 확인
    }

    @Test
    void substring() {
        // "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 "1,2"를 반환하도록 구현한다.
        assertThat(removeBracket("(1,2)")).isEqualTo("1,2");
    }

    private String removeBracket(String str) {
        return str.substring(1, str.length() - 1);
    }

    @Test
    @DisplayName("charAt 학습테스트")
    void charAt1() {
        // "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.
        // JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다.
        assertThat("abc".charAt(0)).isEqualTo('a');
    }

    @Test
    @DisplayName("charAt() StringIndexOutOfBoundsException 발생")
    void charAt2() {
        // String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.
        assertThatThrownBy(() -> "abc".charAt(3)).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range");
    }


}
