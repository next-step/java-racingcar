package step3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Scanner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ViewTest {

    private final Scanner mockScanner = mock(Scanner.class);
    private final InputView inputView = new InputView(mockScanner);

    @DisplayName("자동차 수 입력 테스트")
    @ParameterizedTest
    @CsvSource(value = {"5,5", "4,4"})
    void enterCarCount(int input, int exp) {
        when(mockScanner.nextInt()).thenReturn(input);

        inputView.enterCarCount();

        assertEquals(exp, inputView.getCarCount());
        verify(mockScanner).nextInt();
    }

    @DisplayName("이동횟수 입력 테스트")
    @ParameterizedTest
    @CsvSource(value = {"5,5", "4,4"})
    void enterMoveCount(int input, int exp) {
        when(mockScanner.nextInt()).thenReturn(input);

        inputView.enterMoveCount();

        assertEquals(exp, inputView.getMoveCount());
        verify(mockScanner).nextInt();
    }
}