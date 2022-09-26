package racing.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.domain.Cars;
import racing.domain.MovableStrategy;

class RacingGameServiceImplTest {

    @DisplayName("원하는 자동차 갯수만큼 만들기")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 5, 10})
    void 자동차_만들기(int totalCount) {
        RacingGameService racingGameService = new RacingGameServiceImpl(totalCount, 10);

        Cars cars = racingGameService.prepare();

        assertThat(cars.getCars()).hasSize(totalCount);
    }

    @DisplayName("원하는 만큼 전진하기")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 5, 10})
    void 전진_테스트(int tryCount) {
        RacingGameService racingGameService = new RacingGameServiceImpl(1, tryCount);
        MovableStrategy movableStrategy = () -> 4;

        Cars cars = racingGameService.prepare();
        racingGameService.racing(cars, movableStrategy);

        assertThat(cars.getCars().get(0).getMoved()).isEqualTo("-".repeat(tryCount));
    }

}