package racing.domain.game.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.domain.car.entity.BasicCar;
import racing.domain.game.RacingGame;
import racing.exception.InvalidInputException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameRequestTest {
    @DisplayName("asGame 테스트")
    @CsvSource(value = {
            "A,B,C,D|10",
            "A,B,C|15",
            "A|20"
    }, delimiter = '|')
    @ParameterizedTest
    public void asGameTest(String carNames, int turnSize) {
        GameRequest gameRequest = new GameRequest(carNames, turnSize);
        RacingGame game = gameRequest.asGame(BasicCar::new);
        assertThat(game).isNotNull();
    }

    @DisplayName("asGame InvalidInputException 나오는 경우")
    @CsvSource(value = {
            "ABCDEF,GHIJK|10", // 5자 초과
            "A,D|0" // turn 횟수 1회 미만
    }, delimiter = '|')
    @ParameterizedTest
    public void asGameText_InvalidInputException(String carNames, int turnSize) {
        assertThatThrownBy(() -> {
            GameRequest gameRequest = new GameRequest(carNames, turnSize);
            gameRequest.asGame(BasicCar::new);
        }).isInstanceOf(InvalidInputException.class);
    }
}