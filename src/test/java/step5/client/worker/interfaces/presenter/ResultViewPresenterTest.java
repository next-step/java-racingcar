package step5.client.worker.interfaces.presenter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step5.client.worker.domain.RacingGame;
import step5.client.worker.domain.RacingGameCondition;
import step5.client.worker.domain.RacingGameResponse;
import step5.client.worker.domain.strategy.RandomMovableStrategy;

import static org.assertj.core.api.Assertions.assertThat;

class ResultViewPresenterTest {
    @DisplayName("시뮬레이션 결과가 비어있지 않은 경우 빈 문자열을 반환하지 않음")
    @Test
    void present_return_not_blank_when_simulationResult_is_not_empty() {
        // given
        final RacingGameCondition condition = RacingGameCondition.of("pobi,crong,honux", "5");
        final RacingGame racingGame = RacingGame.of(condition.getCarNames(), new RandomMovableStrategy());
        racingGame.race(condition.getNumberAttempts());
        final RacingGameResponse racingGameResponse = racingGame.getRacingGameResponse();
        final ResultViewPresenter presenter = new ResultViewPresenter();

        // when
        final String result = presenter.present(racingGameResponse);

        // then
        assertThat(result).isNotBlank();
    }
}