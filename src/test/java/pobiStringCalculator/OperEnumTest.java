package pobiStringCalculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OperEnumTest {
    @Test
    void of() {
        assertThat(OperEnum.of("+")).isEqualTo(OperEnum.PLUS);
        assertThat(OperEnum.of("-")).isEqualTo(OperEnum.MINUS);
        assertThat(OperEnum.of("*")).isEqualTo(OperEnum.MULTI);
        assertThat(OperEnum.of("/")).isEqualTo(OperEnum.DIVID);
    }
}
