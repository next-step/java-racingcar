package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.AssertionsForClassTypes.*;

public class StringTest {

    @Test
    @DisplayName(value = "요구 사항1 : 1,2을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인")
    void split() {
        String[] result = "1,2".split(",");

        assertThat(result).containsExactly("1","2");
    }

    @Test
    @DisplayName(value = "요구 사항2 : (1,2) 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 1,2 를 반환")
    void substring() {
        String str = "(1,2)";

        String result = str.substring(1,str.length()-1);

        assertThat(result).contains("1","2");
    }

    @Test
    @DisplayName(value = "요구 사항3 : 'abc' 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트")
    void charAt() {
        String str = "abc";

        assertThatThrownBy(()->{
           str.charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class)
            .hasMessageContaining("range: 3")
            .hasMessageMatching("String index out of range: \\d+")
            .hasMessage("String index out of range: %s",3)
            .hasMessageEndingWith("3")
            .hasCauseInstanceOf(IllegalArgumentException.class);

    }
}
