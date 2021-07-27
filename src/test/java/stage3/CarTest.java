package stage3;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CarTest {
    private Car c;

    @BeforeAll
    void setup() {
        c = new Car();
    }

    @DisplayName("input 비정상 case - 음수")
    @ParameterizedTest
    @ValueSource(ints = {-1, -2})
    void invalidInputTest(int input) {
        // when
        Throwable throwable = catchThrowable(() -> c.validateInput(input));

        // than
        assertThat(throwable).isExactlyInstanceOf(IllegalArgumentException.class); // todo
    }
}
