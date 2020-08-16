package cc.oakk.racing.util;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ValidatorTest {
    @Test
    void checkList_ShouldThrow_IllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> Validator.checkList(null));
        assertThatIllegalArgumentException().isThrownBy(() -> Validator.checkList(new ArrayList<>()));
    }

    @Test
    void checkGreaterThanZero_ShouldThrow_IllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> Validator.checkGreaterThanZero(0));
        assertThatIllegalArgumentException().isThrownBy(() -> Validator.checkGreaterThanZero(-1));
        assertThatIllegalArgumentException().isThrownBy(() -> Validator.checkGreaterThanZero(Integer.MIN_VALUE));
    }
}
