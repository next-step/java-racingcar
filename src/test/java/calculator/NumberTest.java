package calculator;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

public class NumberTest {

    @Nullable
    private Number nullableNumber;

    @NotNull
    private Number one;
    @NotNull
    private Number two;
    @NotNull
    private Number ten;
    @NotNull
    private Number twoPointFive;

    @BeforeEach
    void setUp() {
        nullableNumber = null;
        one = NumberManager.getNumberFrom(1);
        two = NumberManager.getNumberFrom(2);
        ten = NumberManager.getNumberFrom(10);
        twoPointFive = NumberManager.getNumberFrom(2.5);
    }

    @Test
    void operatorThrowTest() {
        assertThatNullPointerException().isThrownBy(() -> one.plus(nullableNumber));
        assertThatNullPointerException().isThrownBy(() -> one.minus(nullableNumber));
        assertThatNullPointerException().isThrownBy(() -> one.multiply(nullableNumber));
        assertThatNullPointerException().isThrownBy(() -> one.divide(nullableNumber));
    }

    @Test
    void plusTestForDecimalNumber() {
        assertThat(twoPointFive.plus(twoPointFive).toString()).isEqualTo("5.0");
    }

    @Test
    void minusTestForDecimalNumber() {
        assertThat(twoPointFive.minus(twoPointFive).toString()).isEqualTo("0.0");
    }

    @Test
    void multiplyTestForDecimalNumber() {
        assertThat(twoPointFive.multiply(twoPointFive).toString()).isEqualTo("6.25");
    }

    @Test
    void divideTestForDecimalNumber() {
        assertThat(twoPointFive.divide(twoPointFive).toString()).isEqualTo("1.0");
    }
}
