package step1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Created By mand2 on 2020-10-29.
 */
public class StringTest {

    @Test
    @DisplayName("\"1,2\"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.")
    public void 요구사항1_1() {
        String input = "1,2";
        String[] result = input.split(",");
        assertThat(result).contains("1","2");
    }


    @Test
    @DisplayName("\"1\"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.")
    public void 요구사항1_2() {
        String input = "1";
        String[] result = input.split(",");
        assertThat(result).containsExactly("1");
    }


    @Test
    @DisplayName("\"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 " +
            "()을 제거하고 \"1,2\"를 반환하도록 구현한다.")
    public void 요구사항2() {
        String input = "(1,2)";
        String result = input.substring(1, input.length() - 1);
        assertThat(result).isEqualTo("1,2");
    }


    @Test
    @DisplayName("\"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 " +
            "특정 위치의 문자를 가져오는 학습 테스트를 구현한다.")
    public void 요구사항3() {
        String input = "abc";
        assertThat(input.charAt(0)).isEqualTo('a');
        assertThat(input.charAt(1)).isEqualTo('b');
        assertThat(input.charAt(2)).isEqualTo('c');
        assertThatThrownBy(() ->input.charAt(3)).isInstanceOf(IndexOutOfBoundsException.class);
        assertThatThrownBy(() ->input.charAt(-1)).isInstanceOf(IndexOutOfBoundsException.class);
    }

}
