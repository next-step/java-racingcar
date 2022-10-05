package racing.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.domain.Cars;
import racing.ui.ResultView;
import racing.ui.ResultViewImpl;

class RacingGameServiceImplTest {

    @DisplayName("원하는 자동차 갯수만큼 만들기")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 5, 10})
    void 자동차_만들기(int totalCount) {
        RacingGameService racingGameService = new RacingGameService();

        Cars cars = racingGameService.prepare(totalCount);

        assertThat(cars.getCars()).hasSize(totalCount);
    }

    @DisplayName("원하는 만큼 전진하기")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 5, 10})
    void 전진_테스트(int tryCount) {
        RacingGameService racingGameService = new RacingGameService();
        ResultView resultView = new ResultViewImpl();
        Cars cars = racingGameService.prepare(1);

        racingGameService.racing(cars, tryCount, resultView, () -> 1);

        assertThat(cars.getCar(0).getDistance()).isEqualTo(tryCount);
    }

}