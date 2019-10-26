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
        one = new Number(1);
        two = new Number(2);
        ten = new Number(10);
        twoPointFive = new Number(2.5);
    }

    @Test
    void operatorThrowTest() {
        assertThatNullPointerException().isThrownBy(() -> one.plus(nullableNumber));
        assertThatNullPointerException().isThrownBy(() -> one.minus(nullableNumber));
        assertThatNullPointerException().isThrownBy(() -> one.multiply(nullableNumber));
        assertThatNullPointerException().isThrownBy(() -> one.divide(nullableNumber));
    }

    @Test
    void plusTest() {
        assertThat(one.plus(one).toString()).isEqualTo("2");
        assertThat(one.plus(two).toString()).isEqualTo("3");
        assertThat(one.plus(ten).toString()).isEqualTo("10");
        assertThat(one.plus(twoPointFive).toString()).isEqualTo("3.5");
    }
}
