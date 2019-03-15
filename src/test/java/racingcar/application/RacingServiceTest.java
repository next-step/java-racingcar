package racingcar.application;

import org.junit.Test;
import racingcar.application.request.InputView;
import racingcar.application.response.RacingView;
import racingcar.application.response.ResultView;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingServiceTest {
    private static final String TEST_NAMES = "pobi,crong,honux";

    @Test
    public void 경주_영_바퀴() {
        // given
        final RacingService racingService = new RacingService();
        final int time = 0;
        final InputView inputView = new InputView(TEST_NAMES, time);

        // when
        final ResultView view = racingService.race(inputView);

        // then
        assertThat(view.getRaceProgress().get()).hasSize(0);
    }

    @Test
    public void 경주_한_바퀴() {
        // given
        final RacingService racingService = new RacingService();
        final int time = 1;
        final InputView inputView = new InputView(TEST_NAMES, time);

        // when
        final ResultView view = racingService.race(inputView);

        // then
        final List<RacingView> racingViews = view.getRaceProgress()
                .get()
                ;
        final RacingView racingView = racingViews.get(0);
        assertThat(racingViews).hasSize(time);
        assertThat(racingView.getTime()).isEqualTo(time);
        assertThat(racingView.getRacingCarViews().get()).hasSize(TEST_NAMES.split(",").length);
    }
}