package racing.view;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.domain.dto.GameRequest;
import racing.exception.InvalidInputException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DosInputViewTest {
    @CsvSource(value = {
            "A,B,C,D,E,F,G|10",
            "A,B,C,D,E,F,G|20",
            "A|10"
    }, delimiter = '|')
    @ParameterizedTest
    public void inputGameRequestTest(String carNames, int turnSize) {
        InputView inputView = new FakeDosInputView(carNames, turnSize);
        GameRequest gameRequest = inputView.inputGameRequest();
        gameRequest.cars();
        gameRequest.turns();
    }

    @CsvSource(value = {
            "|10",
            "A|0",
            "A|-1"
    }, delimiter = '|')
    @ParameterizedTest
    public void inputGameRequestTest_InvalidInputException(String carNames, int turnSize) {
        assertThatThrownBy(() ->
            inputGameRequestTest(carNames, turnSize)
        ).isInstanceOf(InvalidInputException.class);
    }
}