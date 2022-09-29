package step4;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidationTest {

    @Test
    void test() {
        Assertions.assertThatThrownBy(() -> {
            Validation.checkName("test12345");
        }).isInstanceOf(RuntimeException.class);
    }
}
