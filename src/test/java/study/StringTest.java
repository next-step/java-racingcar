package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringTest {
    @Test
    void split() {
        String[] result = "1,2".split(",");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void substring() {
        String result = "(1,2)".substring(1,4);
        assertThat(result).isEqualTo("1,2");
    }

    @Test
    @DisplayName("chatAt() 메소드를 활용한 등정 위치 문자를 가져오는 학습 테스트")
    void charAt() {
        String result = "abc";

        assertThat(result.charAt(0)).isEqualTo('a');
        assertThat(result.charAt(1)).isEqualTo('b');
        assertThat(result.charAt(2)).isEqualTo('c');

        int outOfIndexValue = 4;

        assertThatThrownBy(() ->{
            result.charAt(outOfIndexValue);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("Index : %d , Size : %d",outOfIndexValue,result.length());
    }
}
