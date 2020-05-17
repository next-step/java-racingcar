package racinggame.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarsTest {

    @DisplayName("자동차 일급 컬렉션 리스트를 생성할 수 있다.")
    @Test
    void canCreateRacingCars() {
        assertThat(RacingCars.newInstance(new String[] { "붕붕이", "싱싱카" }, () -> true)).isNotNull();
    }

    @DisplayName("모든 자동차들을 움직일 수 있다.")
    @ParameterizedTest
    @ValueSource(strings = { "true", "false" })
    void canMoveAllRacingCars(boolean isMovable) {
        RacingCars racingCars = RacingCars.newInstance(new String[] { "붕붕이", "싱싱카" }, () -> isMovable);
        racingCars.moveAll();

        racingCars.getRacingCars().forEach(racingCar -> assertThat(racingCar.getPosition()).isEqualTo(isMovable ? 1 : 0));
    }

    @DisplayName("우승 자동차 이름들을 얻을 수 있다.")
    @Test
    void canGetWinnerCarNamesByRacingCars() {
        RacingCars racingCars = RacingCars.newInstance(new String[] { "붕붕이", "싱싱카" }, () -> true);
        assertThat(racingCars.getWinnerCarNames()).isEqualTo("붕붕이,싱싱카");
    }
}
