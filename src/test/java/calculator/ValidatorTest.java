package calculator;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidatorTest {
    @BeforeAll
    static void initAll() {
        System.out.println("start validator test");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("end validator test");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "  ", "    "})
    void checkEmptyInputTest(String input) {
        assertThatThrownBy(() -> Validator.checkEmptyInput(input)).isInstanceOf(IllegalArgumentException.class);
    }

}