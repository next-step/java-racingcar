package study.step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import step1.StringCalculator2;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Java6Assertions.assertThat;

public class StringCalculator2Test {

    private StringCalculator2 stringCalculator2;

    @BeforeEach
    void setUp() {
        stringCalculator2 = new StringCalculator2();
    }

    @Test
    void addTest() {
        assertThat(stringCalculator2.add(1, 2)).isEqualTo(3);
    }

    @Test
    void subtractTest() {
        assertThat(stringCalculator2.subtract(1, 2)).isEqualTo(-1);
    }

    @Test
    void multiplyTest() {
        assertThat(stringCalculator2.multiply(2, 3)).isEqualTo(6);
    }

    @Test
    void divideTest() {
        assertThat(stringCalculator2.divide(6, 2)).isEqualTo(3);
    }

    @ParameterizedTest
    @NullSource
    @EmptySource
    void nullAndEmptyTest(String request) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            stringCalculator2.execute(request);
        });
    }

    @Test
    void operatorTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            stringCalculator2.execute("1 ^ 2");
        });
    }
}
