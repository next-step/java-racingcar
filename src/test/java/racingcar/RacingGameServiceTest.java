package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Cars;
import racingcar.dto.RacingCarRequestDto;
import racingcar.service.RacingGameService;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class RacingGameServiceTest {
    private static final String RACING_CAR_NAMES = "ALPHA,BETA,CHARLIE";

    @DisplayName("자동차 경주 정상 실행")
    @ParameterizedTest
    @ValueSource(ints = {3, 5, 7})
    void racingGameExecute(int numberOfTime) {
        RacingGameService racingGameService = new RacingGameService();
        List<Cars> cars = racingGameService.executeRacingGameNumberOfTimes(new RacingCarRequestDto(RACING_CAR_NAMES, numberOfTime), () -> true);

        assertThat(cars).size().isEqualTo(numberOfTime);
    }

    @DisplayName("자동자 개수가 1보다 작을 시 레이싱 게임 실행 실패")
    @ParameterizedTest
    @ValueSource(ints = {3})
    void createFailByNumberOfCar(int numberOfTime) {
        String racingCars = "";
        RacingGameService racingGameService = new RacingGameService();

        assertThatIllegalArgumentException().isThrownBy(() -> {
            racingGameService.executeRacingGameNumberOfTimes(new RacingCarRequestDto(racingCars, numberOfTime), () -> true);
        });
    }
}
