package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.car.RandomMovingStrategy;
import racingcar.service.RacingGameService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class RacingGameServiceTest {
    private static final String[] RACING_CAR_NAMES = {"ALPHA", "BETA", "CHARLIE"};

    @DisplayName("자동차 경주 정상 실행")
    @ParameterizedTest
    @ValueSource(ints = {3, 5, 7})
    void racingGameExecute(int numberOfTime) {
        RacingGameService racingGameService = new RacingGameService(RACING_CAR_NAMES, new RandomMovingStrategy());
        racingGameService.executeRacingGameNumberOfTimes(numberOfTime);

        assertThat(racingGameService.getTime()).isEqualTo(numberOfTime);
    }

    @DisplayName("자동자 개수가 1보다 작을 시 생성 실패")
    @Test
    void createFailByNumberOfCar() {
        String[] racingCars = {};
        assertThatIllegalArgumentException().isThrownBy(() -> new RacingGameService(racingCars, new RandomMovingStrategy()));
    }
}
