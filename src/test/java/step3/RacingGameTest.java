package step3;

import static org.assertj.core.api.Java6Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class RacingGameTest {

    private static final int DEFAULT_TIME = 3;

    @DisplayName("자동차 게임 생성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5})
    void initRacingCarTest(int racingCarCount) {
        RacingGame racingGame = RacingGame.create(DEFAULT_TIME, new RandomMovingStrategy());
        racingGame.readyRacingCars(racingCarCount);
    }

    @DisplayName("자동차의 start 메소드 테스트")
    @ParameterizedTest
    @MethodSource("startRacingGame")
    void startRacingGame(int racingCarCount, int time, boolean isMovable, int expected) {
        //given
        RacingGame racingGame = RacingGame.create(time, new StubMovingStrategyTest(isMovable));
        racingGame.readyRacingCars(racingCarCount);

        //when
        List<RacingCar> racingCars = new ArrayList<>();
        for (int i = 0; i < time; i++) {
            racingCars = racingGame.startRacing();
        }

        //then
        for (int i = 0; i < time; i++) {
            for (RacingCar racingCar : racingCars) {
                assertThat(racingCar.currentPosition()).isEqualTo(expected);
            }
        }
    }

    static Stream<Arguments> startRacingGame() {
        return Stream.of(
            Arguments.of(3, 4, true, 4),
            Arguments.of(3, 4, false, 0)
        );
    }
}