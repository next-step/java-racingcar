package calulator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StringCaluculatorTest {
    @Test
    void addTest() {
        StringCaluculator stringCaluculator = new StringCaluculator();
        assertThat(stringCaluculator.calculate("1+2")).isEqualTo(3);
    }

    @Test
    void subTest() {
        StringCaluculator stringCaluculator = new StringCaluculator();
        assertThat(stringCaluculator.calculate("2-1")).isEqualTo(1);
    }

    @Test
   // @DisplayName("곱하기")
    void mulTest() {
        StringCaluculator stringCaluculator = new StringCaluculator();
        assertThat(stringCaluculator.calculate("2*3")).isEqualTo(6);
    }

    @Test
  //  @DisplayName("나누기")
    void diviTest() {
        StringCaluculator stringCaluculator = new StringCaluculator();
        assertThat(stringCaluculator.calculate("4/2")).isEqualTo(2);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void name(String input) {
        StringCaluculator stringCaluculator = new StringCaluculator();
        assertThatIllegalArgumentException()
                .isThrownBy(() -> stringCaluculator.calculate(input));
    }
}