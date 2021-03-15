package step3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Scanner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step3.view.InputView;
import step3.util.CarConstant;

public class ViewTest {

    private final Scanner mockScanner = mock(Scanner.class);
    private final InputView inputView = new InputView(mockScanner);

    @DisplayName("자동차 수 입력 테스트")
    @ParameterizedTest
    @CsvSource(value = {"5,5", "4,4"})
    void enterCarCount(int input, int exp) {
        when(mockScanner.nextInt()).thenReturn(input);

        int carCount = inputView.enterCarCount();

        assertEquals(exp, carCount);
        verify(mockScanner).nextInt();
    }

    @DisplayName("시도횟수 입력 테스트")
    @ParameterizedTest
    @CsvSource(value = {"5,5", "4,4"})
    void enterMoveCount(int input, int exp) {
        when(mockScanner.nextInt()).thenReturn(input);

        int roundCount = inputView.enterRoundCount();

        assertEquals(exp, roundCount);
        verify(mockScanner).nextInt();
    }

    @DisplayName("자동차 이름이 5글자 이상이면 IllegalArgumentException")
    @ParameterizedTest
    @CsvSource(value = {"pobiasd,crong,honux", "pobi,crongadsf,honux"}, delimiter = ':')
    void validateCarName(String input) {
        String[] names = inputView.splitInput(input);

        assertThrows(IllegalArgumentException.class, () -> inputView.validateCarName(names, CarConstant.MOVE_CRITERIA));
    }
}