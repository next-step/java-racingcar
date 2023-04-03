package step1;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @DisplayName("1,2 을 ','로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.")
    @Test
    void requirements_1_1() {

        String str = "1,2";
        String[] split = str.split(",");
        assertThat(split).containsExactly("1", "2");

    }

    @DisplayName("1 을 ','로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.")
    @Test
    void requirements_1_2() {

        String str = "1";
        String[] split = str.split(",");
        assertThat(split).containsOnly(str);

    }

    @DisplayName("(1,2) 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 '1,2'를 반환하도록 구현한다.")
    @Test
    void requirements_2() {
        String str = "(1,2)";
        String substring = str.substring(1, 4);
        assertThat(substring).isEqualTo("1,2");
    }


    @DisplayName("abc 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.")
    @Test
    void requirements_3_1() {
        String str = "abc";
        {
            char a = str.charAt(0);
            assertThat(a).isEqualTo('a');
        }

        {
            char b = str.charAt(1);
            assertThat(b).isEqualTo('b');
        }

        {
            char c = str.charAt(2);
            assertThat(c).isEqualTo('c');
        }
    }

    @DisplayName("String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.")
    @Test
    void requirements_3_2() {
        String str = "abc";
        assertThatThrownBy(() -> {
            char exception = str.charAt(str.length() + 1);
        }).isInstanceOf(IndexOutOfBoundsException.class);
    }
}
