package stringCalculator;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class InputStringHandlerTest {

    private InputStringHandler inputStringHandler;

    @BeforeEach
    void setUp() {
        inputStringHandler = new InputStringHandler();
    }

//    @ParameterizedTest
//    @ValueSource(strings = {"", " "})
//    void emptyInputExceptionTest(String input) {
//
//        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
//            inputStringHandler.emptyInputException(input);
//        });
//    }
}
