package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @DisplayName("1,2을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인한다.")
    @Test
    void test1() {
        String num = "1,2";
        String[] numArr = num.split(",");

        assertThat(numArr).contains("2", "1");
        assertThat(numArr).containsExactly("1", "2");
    }

    @DisplayName("(1,2)을 substring을 하여 1,2로 잘 나뉘어 졌는지 확인한다.")
    @Test
    void test2() {
        String num = "(1,2)";
        String subNum = num.substring(1,4);

        assertThat(subNum).isEqualTo("1,2");
    }

    @DisplayName("abc 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다")
    @Test
    void test3() {
        String str = "abc";

        assertThat(str.charAt(0)).isEqualTo('a');
    }

    @DisplayName("abc 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올시 범위를 벗어나면 예외를 발생시킨다.")
    @Test
    void test4() {
        String str = "abc";
        assertThatThrownBy(() -> str.charAt(4))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessage("String index out of range: 4");
    }
}
