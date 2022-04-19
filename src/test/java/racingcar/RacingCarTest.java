package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.controller.RacingCar;
import racingcar.dto.InputCars;
import racingcar.dto.RoundResult;
import racingcar.model.Distance;
import racingcar.model.RandomMovingStrategy;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.InputCarsTest.TEST_INPUT_CARS;

@DisplayName("자동차 경주 게임 테스트")
public class RacingCarTest {

    @Test
    @DisplayName("주어진 횟수는 0 이상이어야 한다.")
    void roundCountTest() {
        assertThatThrownBy(() -> new RacingCar(TEST_INPUT_CARS, -1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("주어진 횟수는 0 이상이어야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 5})
    @DisplayName("자동차의 현재 상태는 주어진 횟수값을 넘지 않는다.")
    void carsStateTest(int count) {
        // given
        RacingCar racingCar = new RacingCar(TEST_INPUT_CARS, count);

        // when
        List<RoundResult> playResult = racingCar.play(new RandomMovingStrategy());

        // then
        List<Distance> lastGameResult = playResult.get(playResult.size() - 1).getStates();
        for (Distance result : lastGameResult) {
            assertThat(result.value()).isLessThanOrEqualTo(count);
        }
    }

    @Test
    @DisplayName("모두 movable하다면 Car의 상태는 round횟수와 같다.")
    void allMovableTest() {
        // given
        RacingCar racingCar = new RacingCar(TEST_INPUT_CARS, 5);

        // when
        List<RoundResult> playResult = racingCar.play(() -> true);

        // then
        for (int round = 1; round <= playResult.size(); round++) {
            int index = round - 1;
            List<Distance> states = playResult.get(index).getStates();
            for (Distance state : states) {
                assertThat(state.value()).isEqualTo(round);
            }
        }
    }

    @Test
    @DisplayName("모두 unmovable하다면 Car의 상태는 항상 0이다.")
    void allunMovableTest() {
        // given
        RacingCar racingCar = new RacingCar(TEST_INPUT_CARS, 3);

        // when
        List<RoundResult> playResult = racingCar.play(() -> false);

        // then
        for (int round = 1; round <= playResult.size(); round++) {
            int index = round - 1;
            List<Distance> states = playResult.get(index).getStates();
            for (Distance state : states) {
                assertThat(state.value()).isZero();
            }
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"test", "test1,test2", "test1,test2,test3"})
    @DisplayName(",로 구분한 자동차 이름만큼 결과값이 생성된다")
    void roundResultSizeTest(String inputCarsInfo) {
        // given
        RacingCar racingCar = new RacingCar(InputCars.fromCarsInfo(inputCarsInfo), 1);

        // when
        List<RoundResult> playResult = racingCar.play(new RandomMovingStrategy());

        // then
        assertThat(playResult).hasSize(1);
        assertThat(playResult.get(0).getCarsCount()).isEqualTo(inputCarsInfo.split(",").length);
    }

    @Test
    @DisplayName("자동차 경주 결과에서 자동차의 이름을 받아올 수 있다")
    void roundResultCarNameTest() {
        // given
        String input = "test";
        RacingCar racingCar = new RacingCar(InputCars.fromCarsInfo(input), 1);

        // when
        List<RoundResult> playResult = racingCar.play(new RandomMovingStrategy());

        // then
        String[] split = input.split(",");
        for (RoundResult roundResult : playResult) {
            for (int i = 0; i < split.length; i++) {
                assertThat(roundResult.getCarNames().get(i).value()).isEqualTo(split[i]);
            }
        }
    }
}
