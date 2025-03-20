package ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InputViewTest {

    public Scanner getScannerWithInput(String input) {
        return new Scanner(new ByteArrayInputStream(input.getBytes()));
    }

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

    @DisplayName("정수 이외의 값 입력 테스트")
    @Test
    void testQueryIntegerInputWithPromptInvalidInput() {
        // Arrange
        String script = "a\n1.3\n테스트\n3\n";
        InputView inputView = new InputView(getScannerWithInput(script));

        // Act
        Integer result = inputView.queryIntegerInputWithPrompt("Enter an integer: ");

        // Assert
        assertEquals(3, result);
    }
}
