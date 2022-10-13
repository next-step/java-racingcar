package nextstep.javaracingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static nextstep.javaracingcar.PositiveNumber.from;
import static org.assertj.core.api.Assertions.assertThat;

class CarRacingGameTest {

    private final MovingStrategy ONE_MOVING_ENGINE = () -> Distance.ONE;

    @DisplayName("게임을 시작시 자동차수와 시도할 횟수를 입력 받는다.(0 보다 크거나 같다)")
    @Test
    public void spec01() {
        final MovingStrategy DUMMY_ENGINE = () -> Distance.ZERO;
        final CarRacingGame carRacingGame = new CarRacingGame(from(1), new Round(1), DUMMY_ENGINE);
        assertThat(carRacingGame).isNotNull();
    }

    @DisplayName("입력 받은 수 만큼 자동차를 생성한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 20})
    public void spec02(final int carCount) {
        final CarRacingGame carRacingGame = new CarRacingGame(from(carCount), new Round(1), ONE_MOVING_ENGINE);
        assertThat(carRacingGame.result()).hasSize(carCount);
    }

    @DisplayName("콤마로 연결되 자동차 이름으로 자동차를 생성한다.")
    @Test
    public void spec02_01() {
        final CarRacingGame carRacingGame = new CarRacingGame("aa,bb,cc,dd", new Round(1), ONE_MOVING_ENGINE);
        final CarRacingResult racingResult = carRacingGame.result();
        assertThat(racingResult).hasSize(4);
        assertThat(racingResult).containsExactly(
                carDrivingResult("aa", Distance.ZERO),
                carDrivingResult("bb", Distance.ZERO),
                carDrivingResult("cc", Distance.ZERO),
                carDrivingResult("dd", Distance.ZERO)
        );
    }

    @DisplayName("입력 받은 수 만큼 라운드를 진행한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 20})
    public void spec03(final int round) {
        final CarRacingGame carRacingGame = new CarRacingGame(from(1), new Round(round), ONE_MOVING_ENGINE);
        int roundCounter = 0;
        while (carRacingGame.hasNextRound()) {
            final CarRacingResult racingResult = carRacingGame.runRound();
            roundCounter++;
        }

        assertThat(roundCounter).isEqualTo(round);
    }

    @DisplayName("round 마다 현재 결과를 노출한다.")
    @ParameterizedTest
    @CsvSource({"1,3", "5,10", "3,6"})
    public void spec04(final int carCount, final int round) {
        final CarRacingGame carRacingGame = new CarRacingGame(from(carCount), new Round(round), ONE_MOVING_ENGINE);
        int roundCounter = 0;
        while (carRacingGame.hasNextRound()) {
            final CarRacingResult racingResult = carRacingGame.runRound();
            roundCounter++;
            assertThat(racingResult).hasSize(carCount);
            assertThat(racingResult).containsAll(drivingResults(carCount, new Distance(roundCounter)));
        }
    }

    /*
     * fixture tools
     * */
    private List<CarDrivingResult> drivingResults(final int carCount, final Distance distance) {
        final List<CarDrivingResult> drivingResults = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            drivingResults.add(new CarDrivingResult(String.valueOf(i), distance));
        }
        return drivingResults;
    }

    private CarDrivingResult carDrivingResult(final String name, final Distance distance) {
        return new CarDrivingResult(new CarName(name), distance);
    }
}
