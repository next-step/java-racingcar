package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.dto.CarDto;
import racingcar.helper.Fixture;
import racingcar.param.RacingCarInitParam;
import racingcar.strategy.MoveStrategy;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("레이싱 카 게임 테스트")
class CarRacingTest {

    @DisplayName("레이싱 카 게임은 차의 이름과 라운드 수 를 가지고 초기화 한다.")
    @Test
    void init_temp() {
        assertThat(CarRacing.init(RacingCarInitParam.of(5, "nok", "cha", "x"))).isNotNull();
    }

    @DisplayName("총 라운드 수는 1 이상이다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void roundShouldBeOverZero(int totalRound) {
        assertThatThrownBy(() -> Fixture.testCarRacing(totalRound, 10))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("레이스를 진행하면 차들이 한 번 움직임을 시도한다.")
    @Test
    void raceMakeCarsTryMove() {
        CarRacing carRacing = Fixture.testCarRacing(1, 2);
        List<CarDto> carDtos = carRacing.currentState();
        carDtos.forEach(carDto -> assertThat(carDto.getPosition()).isEqualTo(0));

        carRacing.race(Fixture.ALWAYS_MOVE_STRATEGY);

        carDtos = carRacing.currentState();
        carDtos.forEach(carDto -> assertThat(carDto.getPosition()).isEqualTo(1));
    }

    @DisplayName("현재 라운드 수는 총 라운드 수를 넘길 수 없다.")
    @Test
    void currentRoundCantExceedTotalRound() {
        CarRacing carRacing = Fixture.testCarRacing(1, 10);

        carRacing.race(Fixture.ALWAYS_MOVE_STRATEGY);

        assertThatThrownBy(() -> carRacing.race(Fixture.ALWAYS_MOVE_STRATEGY)).isInstanceOf(IllegalStateException.class);
    }

    @DisplayName("경주 종료 여부를 리턴한다.")
    @Test
    void isRaceOver() {
        int totalRound = 10;
        CarRacing carRacing = Fixture.testCarRacing(totalRound, 2);

        assertThat(carRacing.isRaceOver()).isFalse();

        IntStream.range(0, totalRound)
                .forEach(i -> carRacing.race(Fixture.ALWAYS_MOVE_STRATEGY));

        assertThat(carRacing.isRaceOver()).isTrue();
    }

    @DisplayName("자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한명 이상일 수 있다.")
    @MethodSource
    @ParameterizedTest
    void carRacingHasWinner(int numberOfCars, int totalRound, MoveStrategy moveStrategy, List<String> winners) {
        CarRacing carRacing = Fixture.testCarRacing(totalRound, numberOfCars);

        IntStream.range(0, totalRound)
                .forEach(i -> carRacing.race(moveStrategy));

        assertThat(carRacing.winners()).isEqualTo(winners);
    }

    private static Stream<Arguments> carRacingHasWinner() {
        return Stream.of(
                Arguments.of(
                        10,
                        2,
                        new MoveStrategy() { // 짝수일 때 true 를 리턴하는 전략
                            private int count = 0;
                            @Override
                            public boolean isMovable() {
                                return ++count / 2 == 0;
                            }
                        },
                        new String[] {"1"}
                ),
                Arguments.of(
                        10,
                        10,
                        new MoveStrategy() { // 짝수일 때 true 를 리턴하는 전략
                            private int count = 0;
                            @Override
                            public boolean isMovable() {
                                return ++count / 2 == 0;
                            }
                        },
                        new String[] {"1", "3", "5", "7", "9"}
                )
        );
    }
}
