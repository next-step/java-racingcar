import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class StringTest {

    @DisplayName("\"1,2\"를 , String의 split()으로 분리했을 때 1과 2로 결과값이 나오는지 확인")
    @Test
    void splitStringConsistingOf1And2ByComma() {
        String[] data = "1,2".split(",");
        assertThat(data).contains("1", "2");
    }

    @DisplayName("\"1\"를 , String의 split()으로 분리했을 때 1로만 결과값이 나오는지 확인")
    @Test
    void splitStringConsistingOf1ByComma() {
        String[] data = "1".split(",");
        assertThat(data).containsExactly("1");
    }

    @DisplayName("\"(1,2)\"를 , String의 substring()으로 분리했을 때 \"1,2\"로 결과값이 나오는지 확인")
    @Test
    void substringStringConsistingOf1And2InParentheses() {
        String oneAndTwoInParentheses = "(1,2)";
        String result = oneAndTwoInParentheses.substring(1, oneAndTwoInParentheses.length() - 1);
        assertThat(result).containsOnlyOnce("1,2");
    }

    @DisplayName("\"A,B,C\"가 주어졌을 때, 각 위치에 존재하는 문자 확인 및 범위 벗어났을시 " +
            "StringIndexOutOfBoundsException이 발생하는지 확인")
    @Test
    void charAtStringConsistingOfABC() {
        String abc = "ABC";

        assertAll(
                () -> assertThatThrownBy(() -> {
                    assertThat(abc.charAt(-1)).isEqualTo('C');
                }).isInstanceOf(IndexOutOfBoundsException.class)
                        .hasMessageContaining("String index out of range: -1"),

                () -> assertThat(abc.charAt(0)).isEqualTo('A'),
                () -> assertThat(abc.charAt(1)).isEqualTo('B'),
                () -> assertThat(abc.charAt(2)).isEqualTo('C'),

                () -> assertThatThrownBy(() -> {
                    assertThat(abc.charAt(abc.length())).isEqualTo('C');
                }).isInstanceOf(IndexOutOfBoundsException.class)
                        .hasMessageContaining("String index out of range: 3")
        );

    }

}