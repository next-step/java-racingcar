package racing.domain.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.domain.dto.GameRequest;
import racing.exception.InvalidInputException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameRequestTest {
    @DisplayName("cars 테스트")
    @ValueSource(strings = {
            "A,B,C,D",
            "A,B,C",
            "A"
    })
    @ParameterizedTest
    public void carsTest(String carNames) {
        GameRequest gameRequest = new GameRequest(carNames, 1);
        assertThat(
                gameRequest.cars()
        ).isNotNull();
    }

    @DisplayName("cars InvalidInputException 나오는 경우")
    @ValueSource(strings = {
            "",
            "ABCEDF"
    })
    @ParameterizedTest
    public void carsTest_InvalidInputException(String carNames) {
        assertThatThrownBy(() ->
                carsTest(carNames)
        ).isInstanceOf(InvalidInputException.class);
    }


    @DisplayName("turns 테스트")
    @ValueSource(ints = {
            1,
            10,
            100000
    })
    @ParameterizedTest
    public void turnsTest(int turnSize) {
        GameRequest gameRequest = new GameRequest("A", turnSize);
        assertThat(
                gameRequest.turns()
        ).isNotNull();
    }

    @DisplayName("turns InvalidInputException 나오는 경우")
    @ValueSource(ints = {
            -1,
            0
    })
    @ParameterizedTest
    public void turnsTest_InvalidInputException(int turnSize) {
        assertThatThrownBy(() ->
                turnsTest(turnSize)
        ).isInstanceOf(InvalidInputException.class);
    }
}