package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @Test
    @DisplayName("1, 2를 ,로 split하면 1과 2로 분리된다.")
    void splitOneAndTwoWithComma() {
        String value = "1,2";
        String[] values = value.split(",");


        assertThat(values).contains("1", "2");
    }

    @Test
    @DisplayName("1 ,로 split하면 1만을 포함하는 배열이 반환된다.")
    void splitOneWithComma() {
        String value = "1";
        String[] values = value.split(",");

        assertThat(values).containsOnly("1");
    }

    @Test
    @DisplayName("(1, 2)값에서 substring 메소드를 활용하여 1, 2를 반환한다.")
    void substringOneAndTwo() {
        String value = "(1, 2)";
        assertThat(value.substring(1, value.length() - 1)).isEqualTo("1, 2");
    }

    @Test
    @DisplayName("abc 값이 주어졌을 때 charAt() 메소드를 활용해 특정 위치를 가져온다")
    void getSpecificCharUsingCharAt() {
        String value = "abc";
        assertThat(value.charAt(0)).isEqualTo('a');
        assertThat(value.charAt(1)).isEqualTo('b');
        assertThat(value.charAt(2)).isEqualTo('c');
    }

    @Test
    @DisplayName("charAt()에서 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생한다.")
    void occurExceptionWhenIndexIsInvalid() {
        String value = "abc";
        assertThatThrownBy(() -> {
            System.out.println(value.charAt(3));
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }
}
