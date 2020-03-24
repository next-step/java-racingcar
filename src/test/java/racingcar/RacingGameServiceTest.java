package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.RacingScore;
import racingcar.service.RacingGameService;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class RacingGameServiceTest {
    private static final String[] RACING_CAR_NAMES = {"ALPHA", "BETA", "CHARLIE"};

    @DisplayName("자동차 경주 정상 실행")
    @ParameterizedTest
    @ValueSource(ints = {3, 5, 7})
    void racingGameExecute(int numberOfTime) {
        RacingGameService racingGameService = new RacingGameService();
        racingGameService.createRacingCar(RACING_CAR_NAMES);
        List<RacingScore> racingScores = racingGameService.executeRacingGameNumberOfTimes(numberOfTime, () -> true);

        assertThat(racingScores).size().isEqualTo(numberOfTime);
    }

    @DisplayName("자동자 개수가 1보다 작을 시 생성 실패")
    @Test
    void createFailByNumberOfCar() {
        String[] racingCars = {};
        assertThatIllegalArgumentException().isThrownBy(() -> new RacingGameService().createRacingCar(racingCars));
    }
}
