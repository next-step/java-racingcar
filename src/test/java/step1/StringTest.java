package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringTest {

    @Test
    @DisplayName("특정 String 값에 대해 split 테스트")
    void test1() {
        assertThat("1,2".split(",")).contains("1", "2");
        assertThat("1".split(",")).containsExactly("1");
    }

    @Test
    @DisplayName("특정 String에 대해 subString 하여 원하는 값 만들기")
    void test2(){
        assertThat("(1,2)".substring(1, 4)).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt 메서드를 활용한 특정위치 문자 가져오기 및 위치 값 초과의 경우 예외 확인")
    void test3(){
        String param = "abc";
        assertThat(param.charAt(0)).isEqualTo('a');
        assertThat(param.charAt(1)).isEqualTo('b');
        assertThat(param.charAt(2)).isEqualTo('c');

        assertThatThrownBy(() -> {
            "abc".charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: " + 3);
    }
}
