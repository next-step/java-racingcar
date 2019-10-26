package calculator;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatNullPointerException;

public class NumberTest {

    @Nullable
    private Number nullableNumber;

    @NotNull
    private Number one;

    @BeforeEach
    void setUp() {
        nullableNumber = null;
        one = new Number(1);
    }

    @Test
    void operatorThrowTest() {
        assertThatNullPointerException().isThrownBy(() -> one.plus(nullableNumber));
        assertThatNullPointerException().isThrownBy(() -> one.minus(nullableNumber));
        assertThatNullPointerException().isThrownBy(() -> one.multiply(nullableNumber));
        assertThatNullPointerException().isThrownBy(() -> one.divide(nullableNumber));
    }
}
