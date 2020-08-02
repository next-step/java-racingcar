import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class OperatorTest {
    Operator operator;

    @BeforeEach
    void setUp() {
        operator = new Operator();
    }

    @Test
    public void puls() {
        assertThat(operator.plus(2, 4)).isEqualTo(6);
    }

    @Test
    public void minus() {
        assertThat(operator.minus(2, 4)).isEqualTo(-2);
    }

    @Test
    public void multiply() {
        assertThat(operator.multiply(2, 4)).isEqualTo(8);
    }

    @Test
    public void divide() {
        assertThat(operator.divide(4, 2)).isEqualTo(2);
    }

    @Test
    public void divide_By_Zero() {
        assertThatThrownBy(() -> operator.divide(3, 0)).isInstanceOf(IllegalArgumentException.class);
    }

}
