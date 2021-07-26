package racing.view;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.domain.car.entity.BasicCar;
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
        inputView.inputGameRequest().asGame(BasicCar::new);
    }

    @CsvSource(value = {
            "|10",
            "A|0",
            "A|-1"
    }, delimiter = '|')
    @ParameterizedTest
    public void inputGameRequestTest_InvalidInputException(String carNames, int turnSize) {
        assertThatThrownBy(() -> {
            InputView inputView = new FakeDosInputView(carNames, turnSize);
            inputView.inputGameRequest().asGame(BasicCar::new);
        }).isInstanceOf(InvalidInputException.class);
    }
}