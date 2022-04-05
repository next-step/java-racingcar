package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class StringTest {

    @Test
    @DisplayName("문자열을 split 했을 떄 올바르게 반환되는지 확인한다.")
    void multipleSplit() {
        assertThat("1,2".split(",")).containsExactly("1","2");
    }

    @Test
    @DisplayName("단일 문자열을 split 했을 떄 올바르게 반환되는지 확인한다.")
    void singleSplit() {
        assertThat("1".split(",")).containsExactly("1");
    }

    @Test
    @DisplayName("substring() 메소드를 활용해 ()를 제거한다.")
    void subString() {
        String str = "(1,2)";
        String result = str.substring(1,4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("chartAt() 메소드를 활용해 특정 위치의 문자를 가져온다.")
    void charAt() {
        String str = "abc";
        assertThat(str.charAt(0)).isEqualTo('a');
    }

    @Test
    @DisplayName("chartAt() 메소드를 활용했을 때 위치 값을 벗어나면 StringIndexOutOfBoundsException 이 발생한다.")
    void charAtExceptionHandling() {
        String str = "abc";
        int outOfIndex = str.length();
        assertThatThrownBy(()->{
            str.charAt(outOfIndex);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
