package racing.view;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.domain.dto.GameRequest;

import static org.assertj.core.api.Assertions.assertThat;

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
        assertThat(gameRequest.cars())
                .isNotNull();
        assertThat(gameRequest.turnSize())
                .isEqualTo(turnSize);
    }
}