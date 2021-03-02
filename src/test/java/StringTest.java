import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class StringTest {

    private String abc;

    @BeforeEach
    void setUp() {
        abc = "ABC";
    }

    @DisplayName("\"1,2\"를 String 의 split()으로 분리했을 때, 1과 2로 결과값이 나오는지 확인")
    @Test
    void splitStringConsistingOf1And2ByComma() {
        String[] data = "1,2".split(",");
        assertThat(data).containsExactly("1", "2");
    }

    @DisplayName("\"1\"를 String 의 split()으로 분리했을 때, 1로만 결과값이 나오는지 확인")
    @Test
    void splitStringConsistingOf1ByComma() {
        String[] data = "1".split(",");
        assertThat(data).containsExactly("1");
    }

    @DisplayName("\"(1,2)\"를 String 의 substring()으로 분리했을 때, \"1,2\"로 결과값이 나오는지 확인")
    @Test
    void substringStringConsistingOf1And2InParentheses() {
        // given
        String oneAndTwoInParentheses = "(1,2)";

        // when
        String result = oneAndTwoInParentheses.substring(1, oneAndTwoInParentheses.length() - 1);

        // then
        assertThat(result).containsOnlyOnce("1,2");
    }

    @DisplayName("\"A,B,C\"가 주어졌을 때, 정상적인 범위일시에 각 위치에 존재하는 문자 확인")
    @Test
    void charAtStringConsistingOfABC() {
        assertAll(
                () -> assertThat(abc.charAt(0)).isEqualTo('A'),
                () -> assertThat(abc.charAt(1)).isEqualTo('B'),
                () -> assertThat(abc.charAt(2)).isEqualTo('C')
        );

    }

    @DisplayName("\"A,B,C\"가 주어졌을 때, 음수가 주어진다면 StringIndexOutOfBoundsException 이 발생하는지 확인")
    @Test
    void charAtStringConsistingOfABCByNegativeNumber() {
        assertThatThrownBy(() -> {
            assertThat(abc.charAt(-1)).isEqualTo('C');
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: -1");
    }

    @DisplayName("\"A,B,C\"가 주어졌을 때, 범위를 벗어난다면 StringIndexOutOfBoundsException 이 발생하는지 확인")
    @Test
    void charAtStringConsistingOfABCByNumbersOutOfRange() {

        assertThatThrownBy(() -> {
            assertThat(abc.charAt(abc.length())).isEqualTo('C');
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }

}