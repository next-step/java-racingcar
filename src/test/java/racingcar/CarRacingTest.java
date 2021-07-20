package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.dto.CarDto;
import racingcar.helper.Fixture;
import racingcar.param.RacingCarInitParam;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("레이싱 카 게임 테스트")
class CarRacingTest {

    @DisplayName("레이싱 카 게임은 차의 숫자와 라운드 수, MoveStrategy 를 가지고 초기화 한다.")
    @Test
    void init() {
        assertThat(CarRacing.init(RacingCarInitParam.of(10, 5))).isNotNull();
    }

    @DisplayName("총 라운드 수는 1 이상이다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void roundShouldBeOverZero(int totalRound) {
        assertThatThrownBy(() -> CarRacing.init(RacingCarInitParam.of(10, totalRound)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("레이스를 진행하면 차들이 한 번 움직임을 시도한다.")
    @Test
    void raceMakeCarsTryMove() {
        CarRacing carRacing = CarRacing.init(RacingCarInitParam.of(2, 1));
        List<CarDto> carDtos = carRacing.currentState();
        carDtos.forEach(carDto -> assertThat(carDto.getPosition()).isEqualTo(0));

        carRacing.race(Fixture.alwaysMoveStrategy());

        carDtos = carRacing.currentState();
        carDtos.forEach(carDto -> assertThat(carDto.getPosition()).isEqualTo(1));
    }

    @DisplayName("현재 라운드 수는 총 라운드 수를 넘길 수 없다.")
    @Test
    void currentRoundCantExceedTotalRound() {
        CarRacing carRacing = CarRacing.init(RacingCarInitParam.of(10, 1));

        carRacing.race(Fixture.alwaysMoveStrategy());

        assertThatThrownBy(() -> carRacing.race(Fixture.alwaysMoveStrategy())).isInstanceOf(IllegalStateException.class);
    }

    @DisplayName("경주 종료 여부를 리턴한다.")
    @Test
    void isRaceOver() {
        int totalRound = 10;
        CarRacing carRacing = CarRacing.init(RacingCarInitParam.of(2, totalRound));

        assertThat(carRacing.isRaceOver()).isFalse();

        IntStream.range(0, totalRound)
                .forEach(i -> carRacing.race(Fixture.alwaysMoveStrategy()));

        assertThat(carRacing.isRaceOver()).isTrue();
    }
}
