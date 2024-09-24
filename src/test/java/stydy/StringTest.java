package stydy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    @Test
    void spilt() {
        String[] result = "1,2".split(",");
        assertThat(result).contains("1");
        assertThat(result).containsExactly("1", "2");
    }

    // 요구사항2 "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 "1,2"를 반환하도록 구현한다.
    @Test
    void subString() {
        String result = "(1,2)".substring(1, 4);
        assertThat(result).isEqualTo("1,2");
    }


    /* 요구사항3
        "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.
        String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundssException이 발생하는 부분에 대한 학습 테스트를 구현한다.
        JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다.
    */
    @Test
    @DisplayName("문자 해당 위치 찾기")
    void findWordLocation() {
        String word = "abc";

        assertThatThrownBy(() -> {
            word.charAt(-1);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);

        assertThatThrownBy(() -> {
            word.charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class);

    }
}
