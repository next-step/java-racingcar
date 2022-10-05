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

    private final CarEngine ONE_MOVING_ENGINE = () -> PositiveNumber.ONE;

    @DisplayName("게임을 시작시 자동차수와 시도할 횟수를 입력 받는다.(0 보다 크거나 같다)")
    @Test
    public void spec01() {
        final CarEngine DUMMY_ENGINE = () -> PositiveNumber.ZERO;
        final CarRacingGame carRacingGame = new CarRacingGame(from(1), from(1), DUMMY_ENGINE);
        assertThat(carRacingGame).isNotNull();
    }

    @DisplayName("입력 받은 수 만큼 자동차를 생성한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 20})
    public void spec02(final int carCount) {
        final CarRacingGame carRacingGame = new CarRacingGame(from(carCount), from(1), ONE_MOVING_ENGINE);
        assertThat(carRacingGame.result()).hasSize(carCount);
    }

    @DisplayName("입력 받은 수 만큼 라운드를 진행한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 20})
    public void spec03(final int round) {
        final CarRacingGame carRacingGame = new CarRacingGame(from(1), from(round), ONE_MOVING_ENGINE);
        int roundCounter = 0;
        while (carRacingGame.hasNextRound()) {
            final List<CarDashboard> result = carRacingGame.runRound();
            roundCounter++;
            System.out.println(result);
        }

        assertThat(roundCounter).isEqualTo(round);
    }

    @DisplayName("round 마다 현재 결과를 노출한다.")
    @ParameterizedTest
    @CsvSource({"1,3", "5,10", "3,6"})
    public void spec04(final int carCount, final int round) {
        final CarRacingGame carRacingGame = new CarRacingGame(from(carCount), from(round), ONE_MOVING_ENGINE);
        int roundCounter = 0;
        while (carRacingGame.hasNextRound()) {
            final List<CarDashboard> result = carRacingGame.runRound();
            roundCounter++;
            assertThat(result).hasSize(carCount);
            assertThat(result).containsAll(dashboards(carCount, from(roundCounter)));
        }
    }

    private List<CarDashboard> dashboards(final int carCount, final PositiveNumber distance) {
        final List<CarDashboard> dashboards = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            dashboards.add(new CarDashboard(String.valueOf(i), distance));
        }
        return dashboards;
    }
}
