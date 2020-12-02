package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    @DisplayName("1,2를 ,로 split 했을 때 1과 2로 잘 분리되는지 확인")
    public void splitContain() {
        // given
        String foo = "1,2";

        // when
        String[] splitFoo = foo.split(",");

        // then
        assertThat(splitFoo).contains("1", "2");
    }

    @Test
    @DisplayName("1울 ,로 split 했을 때 1만 포함하는 배열을 반환하는지 테스트")
    public void splitOneUnit() {
        // given
        String foo = "1";

        // when
        String[] splitFoo = foo.split(",");

        // then
        assertThat(splitFoo).containsExactly("1");
    }

    @Test
    @DisplayName("'(1,2)'값이 주어졌을 때 괄호를 제거하고 1,2가 반환되는지 테스트")
    public void eraseParenthesis() {
        // given
        String foo = "(1,2)";

        // when
        String erasedFoo = foo.substring(1, foo.length() -1);

        // then
        assertThat(erasedFoo).isEqualTo("1,2");

    }

    @Test
    @DisplayName("String.charAt 사용 시 StringIndexOutOfBoundsException 발생 테스트")
    public void stringIndexOutOfBoundsException() {
        // given
        String abc = "abc";

        // when & then
        assertThatThrownBy(() -> {abc.charAt(4);})
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 4")
        ;
    }
}
