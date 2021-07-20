package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.dto.CarDto;
import racingcar.helper.Fixture;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("레이싱 카 게임 테스트")
class RacingCarTest {

    @DisplayName("레이싱 카 게임은 차의 숫자와 라운드 수, MoveStrategy 를 가지고 초기화 한다.")
    @Test
    void init() {
        assertThat(RacingCar.init(10, 5, Fixture.alwaysMoveStrategy())).isNotNull();
    }

    @DisplayName("총 라운드 수는 1 이상이다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void roundShouldBeOverZero(int totalRound) {
        assertThatThrownBy(() -> RacingCar.init(10, totalRound, Fixture.alwaysMoveStrategy()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("레이스를 진행하면 차들이 한 번 움직임을 시도한다.")
    @Test
    void raceMakeCarsTryMove() {
        RacingCar racingCar = RacingCar.init(2, 1, Fixture.alwaysMoveStrategy());
        List<CarDto> carDtos = racingCar.currentState();
        carDtos.forEach(carDto -> assertThat(carDto.getPosition()).isEqualTo(0));

        racingCar.race();

        carDtos = racingCar.currentState();
        carDtos.forEach(carDto -> assertThat(carDto.getPosition()).isEqualTo(1));
    }

    @DisplayName("현재 라운드 수는 총 라운드 수를 넘길 수 없다.")
    @Test
    void currentRoundCantExceedTotalRound() {
        RacingCar racingCar = RacingCar.init(10, 1, Fixture.alwaysMoveStrategy());

        racingCar.race();

        assertThatThrownBy(racingCar::race).isInstanceOf(IllegalStateException.class);
    }

    @DisplayName("경주 종료 여부를 리턴한다.")
    @Test
    void isRaceOver() {
        RacingCar racingCar = RacingCar.init(2, 1, Fixture.alwaysMoveStrategy());

        assertThat(racingCar.isRaceOver()).isFalse();

        racingCar.race();

        assertThat(racingCar.isRaceOver()).isTrue();
    }
}
