package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    void split() {
        String[] splitArray1 = "1,2".split(",");
        Assertions.assertThat(splitArray1).contains("1", "2");

        String[] splitArray2 = "1".split(",");
        Assertions.assertThat(splitArray2).containsExactly("1");
    }

    @Test
    void substring() {
        String str = "(1,2)";

        String result = str.substring(str.indexOf("(") + 1, str.indexOf(")"));

        Assertions.assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("charAt() 메소드를 활용해 특정 위치의 문자를 가져온다. 만약 위치 값을 벗어나면 StringIndexOutOfBoundsException.class를 예외를 발생시킨다.")
    @Test
    void charAt(){
        String str = "abc";

        org.junit.jupiter.api.Assertions.assertAll(
                () -> Assertions.assertThat(str.charAt(0)).isEqualTo('a'),
                () -> Assertions.assertThat(str.charAt(1)).isEqualTo('b'),
                () -> Assertions.assertThat(str.charAt(2)).isEqualTo('c')
        );

        Assertions.assertThatThrownBy(() -> {
                    str.charAt(3);
                }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range");
    }

}
