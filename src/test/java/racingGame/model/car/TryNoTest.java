package racingGame.model.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingGame.model.strategy.RandomMovementStrategy;
import racingGame.service.RacingGameService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TryNoTest {

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("생성자는 입력이 유효한 경우, 객체를 반환한다.")
    void 생성자_성공_테스트(final int number) {
        TryNo expected = new TryNo(number, new RacingGameService(() -> true));

        assertThat(expected.getTryNo()).isEqualTo(number);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    @DisplayName("생성자는 입력이 유효하지 않으면, 에러를 반환한다.")
    void 생성자_실패_테스트(final int number) {
        assertThatThrownBy(() -> new TryNo(number, new RacingGameService(() -> true)))
        .isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"2:1", "3:4", "2:10"}, delimiter = ':')
    @DisplayName("moveCarsForAllRounds 메소드는 입력한 라운드 수만큼, 시도 되어야 한다.")
    public void moveCarsForAllRounds_메소드_테스트(final int carCount, final int tryNo) {
        RacingGameService gameService = new RacingGameService(new RandomMovementStrategy());
        TryNo round = new TryNo(tryNo, gameService);

        CarMovement expected = round.tryForRounds(carCount);

        assertThat(expected.getProgress()).hasSize(tryNo);
    }
}
