package racing.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.Cars;
import racing.view.ResultView;
import racing.view.ResultViewImpl;

class RacingGameServiceImplTest {

    @DisplayName("원하는 자동차 갯수만큼 만들기")
    @Test
    void 자동차_만들기() {
        String[] carNames = { "pobi", "crong", "honux" };
        RacingGameService racingGameService = new RacingGameService();

        Cars cars = racingGameService.prepare(carNames);

        assertThat(cars.getCars()).hasSize(carNames.length);
    }

    @DisplayName("한명이 우승자 일 경우")
    @Test
    void 한명이_우승자_일경우() {
        RacingGameService racingGameService = new RacingGameService();
        ResultView resultView = new ResultViewImpl();
        Cars cars = racingGameService.prepare(new String[] { "pobi" });

        racingGameService.racing(cars, 5, resultView, () -> true);

        assertThat(cars.findWinners()).isEqualTo("pobi");
    }

    @DisplayName("여러명이 동시 우승자 일 경우")
    @Test
    void 동시에_우승자_일경우() {
        RacingGameService racingGameService = new RacingGameService();
        ResultView resultView = new ResultViewImpl();
        Cars cars = racingGameService.prepare(new String[] { "pobi", "crong" });

        racingGameService.racing(cars, 5, resultView, () -> true);

        assertThat(cars.findWinners()).isEqualTo("pobi, crong");
    }

}