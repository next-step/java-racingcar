package stringcalculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CalculationApplicationTest {

    @ParameterizedTest
    @NullSource
    @EmptySource
    @ValueSource(strings = "                    ")
    void shouldNotBeNullOrBlank(String input) {
        CalculationApplication application = new CalculationApplication();
        assertThatIllegalArgumentException()
                .isThrownBy(() -> application.shouldNotBeNullOrBlank(input));
    }
}
