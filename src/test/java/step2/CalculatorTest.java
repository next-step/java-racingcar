package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    @Test
    public void sum() {
        //given
        Calculator c = new Calculator();

        //when
        int result = c.sum(3, 4);

        //then
        assertThat(result).isEqualTo(7);
    }
}
