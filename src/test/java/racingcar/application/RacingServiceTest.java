package racingcar.application;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingServiceTest {
    @Test
    public void 경주_영_바퀴() {
        // given
        final RacingService racingService = new RacingService();
        final int numberOfCars = 3;
        final int time = 0;
        final InputView inputView = new InputView(numberOfCars, time);

        // when
        final List<ResultView> views = racingService.race(inputView);

        // then
        assertThat(views).hasSize(0);
    }

    @Test
    public void 경주_한_바퀴() {
        // given
        final RacingService racingService = new RacingService();
        final int numberOfCars = 3;
        final int time = 1;
        final InputView inputView = new InputView(numberOfCars, time);

        // when
        final List<ResultView> views = racingService.race(inputView);

        // then
        assertThat(views).hasSize(time);
        assertThat(views.get(0).getViews().get()).hasSize(numberOfCars);
    }
}