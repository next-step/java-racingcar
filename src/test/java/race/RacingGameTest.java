package race;

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
        RacingGame racingGame = RacingGame.of(racingCarCount, DEFAULT_TIME, new RandomMovingStrategy());
        racingGame.readyRacingCars(racingCarCount);
        assertThat(racingGame.start().size()).isEqualTo(racingCarCount);
    }

    @DisplayName("자동차의 start 메소드 테스트")
    @MethodSource("startRacingGame")
    @ParameterizedTest
    void startRacingGame(int count, int time, int expected) {
        //given
        RacingGame racingGame = RacingGame.of(count, time, new DummyMovingStrategy());
        racingGame.readyRacingCars(count);

        //when
        List<RacingCar> racingCars = new ArrayList<>();
        for (int i = 0; i < racingGame.getTime(); i++) {
            racingCars = racingGame.start();
        }

        //then
        for (int i = 0; i < racingGame.getTime(); i++) {
            assertThat(racingCars.get(i).getPosition()).isEqualTo(expected);
        }
    }

    static Stream<Arguments> startRacingGame() {
        return Stream.of(
            Arguments.of(3, 2, 2)
        );
    }
}