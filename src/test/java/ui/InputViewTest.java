package ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InputViewTest {

    public Scanner getScannerWithInput(String input) {
        return new Scanner(new ByteArrayInputStream(input.getBytes()));
    }

    /**
     * Test the queryIntegerInputWithPrompt method with a valid integer input.
     */
    @DisplayName("정수 입력 테스트")
    @Test
    void testQueryIntegerInputWithPrompt() {
        // Arrange
        String script = "3\n";
        InputView inputView = new InputView(getScannerWithInput(script));

        // Act
        Integer result = inputView.queryIntegerInputWithPrompt("Enter an integer: ");

        // Assert
        assertEquals(3, result);
    }

    /**
     * Test the queryIntegerInputWithPrompt method with an invalid integer input.
     */
    @DisplayName("정수 이외의 값 입력 테스트")
    @ValueSource(strings = {"a", "1.2", "테스트"})
    @ParameterizedTest
    void testQueryIntegerInputWithPromptInvalidInput(String value) {
        // Arrange
        String script = value + "\n";
        InputView inputView = new InputView(getScannerWithInput(script));

        // Act & Assert
        assertThrows(java.util.InputMismatchException.class, () -> {
            inputView.queryIntegerInputWithPrompt("Enter an integer: ");
        });
    }
}
