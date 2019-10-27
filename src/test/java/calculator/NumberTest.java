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
        one = new IntegerNumber("1");
        two = new IntegerNumber("2");
        ten = new IntegerNumber("10");
        twoPointFive = new DecimalNumber(2.5);
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

    @Test
    void plusTestForIntegerNumber() {
        assertThat(one.plus(ten).toString()).isEqualTo("11");
    }

    @Test
    void minusTestForIntegerNumber() {
        assertThat(one.minus(ten).toString()).isEqualTo("-9");
    }

    @Test
    void multiplyTestForIntegerNumber() {
        assertThat(one.multiply(two).toString()).isEqualTo("2");
    }

    @Test
    void divideTestForIntegerNumber() {
        assertThat(ten.divide(two).toString()).isEqualTo("5");
    }
}
