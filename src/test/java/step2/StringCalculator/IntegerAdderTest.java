package step2.StringCalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class IntegerAdderTest {
@Test
    void add_list_components() {
        String rawInput = "1:2,3:4";
        String rawInput2 = "//&\\n1&2&3&4";

        IntegerAdder sut = new IntegerAdder(rawInput);
        IntegerAdder sut2 = new IntegerAdder(rawInput2);

        assertThat(sut.calculate()).isEqualTo(10);
        assertThat(sut2.calculate()).isEqualTo(10);
    }

    @Test
    void throw_exception_if_wrong_input() {
        String rawInput = "//&\\n1,2:3";

        IntegerAdder sut = new IntegerAdder(rawInput);

        assertThatThrownBy(sut::calculate).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void throw_exception_if_negative() {
        String rawInput = "-1,2:3";

        IntegerAdder sut = new IntegerAdder(rawInput);

        assertThatThrownBy(sut::calculate).isInstanceOf(RuntimeException.class);
    }

    @Test
    void returns_zero_if_empty() {
    String rawInput = "";

    IntegerAdder sut = new IntegerAdder(rawInput);

    assertThat(sut.calculate()).isEqualTo(0);
    }
}
