package racing.view;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.domain.car.entity.BasicCar;
import racing.domain.car.entity.Car;
import racing.domain.car.entity.Cars;
import racing.domain.car.vo.Name;
import racing.domain.game.RacingGame;
import racing.domain.game.dto.GameRequest;
import racing.exception.InvalidInputException;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

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