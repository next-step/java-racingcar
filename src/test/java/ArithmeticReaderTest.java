import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class ArithmeticReaderTest {
    ArithmeticReader reader;

    @BeforeEach
    void setUp() {
        this.reader = new ArithmeticReader();
    }

    @Test
    void isArithmeticExpressionTest() {
        assertThat(reader.isArithmeticExpression("")).isFalse();
    }
}