package racingGame.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingGame.model.car.CarMovement;
import racingGame.model.car.TryNo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class RacingGameServiceTest {

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 4, 5, 6, 7})
    @DisplayName("생성자 메소드는 항상 객체를 생성할 수 있다.")
    public void 생성자_성공_테스트() {
        assertDoesNotThrow(() -> new RacingGameService());
    }

    @ParameterizedTest
    @CsvSource(value = {"2:1", "3:4", "2:10"}, delimiter = ':')
    @DisplayName("moveCarsForAllRounds 메소드는 입력한 라운드 수만큼, 시도 되어야 한다.")
    public void moveCarsForAllRounds_메소드_테스트(final int carCount, final int tryNo) {
        RacingGameService gameService = new RacingGameService();

        CarMovement expected = gameService.moveCarsForAllRounds(carCount, new TryNo(tryNo));

        assertThat(expected.getProgress()).hasSize(tryNo);
    }

}
