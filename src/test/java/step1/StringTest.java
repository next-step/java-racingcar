package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringTest {
    @Test
    void split(){
        String input = "1,2";
        String [] data = input.split(",");
        assertThat(data).contains("1");

    }

    @Test
    void split2() {
        String input2 = "1,2";
        String[] result2 = input2.split(",");
        assertThat(result2).containsExactly("1", "2");
    }

    @Test
    void substring() {
        String input = "(1,2)";
        String result = input.substring(1, input.length()-1);
        assertEquals("1,2", result);
    }

    @Test
    @DisplayName("\"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.")
    void charAt1() {
        String input = "abc";

        char firstIndex = input.charAt(0);
        char secondIndex = input.charAt(1);
        char thirdIndex = input.charAt(2);

        assertThat(firstIndex).isEqualTo('a');
        assertThat(secondIndex).isEqualTo('b');
        assertThat(thirdIndex).isEqualTo('c');

    }

    @Test
    @DisplayName("String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생")
    void charAt2(){
        String input = "abc";
        Throwable throwable = catchThrowable(() -> input.charAt(4));
        assertThat(throwable)
                .isInstanceOf(StringIndexOutOfBoundsException.class);

    }
}
