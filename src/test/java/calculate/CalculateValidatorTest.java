package calculate;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculateValidatorTest {
    @Test
    void calculableStringSuccessTest() {
        Assertions.assertThat(
            CalculateValidator.isCalculable("2 + 3 * 4 / 2")
        ).isTrue();
    }
    
    @Test
    void calculableStringFailTest() {
        Assertions.assertThat(
            CalculateValidator.isCalculable("2 + 3 * 4 /")
        ).isFalse();
    
        Assertions.assertThat(
            CalculateValidator.isCalculable("2 + a * 4 / 1")
        ).isFalse();
        
        Assertions.assertThat(
            CalculateValidator.isCalculable("2 + 3 * 4 ? 2")
        ).isFalse();
    
        Assertions.assertThat(
            CalculateValidator.isCalculable("2 + 3*4 + 2")
        ).isFalse();
    }
}
