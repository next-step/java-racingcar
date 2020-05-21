package step4;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.Java6Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class RacingGameTest {

    @DisplayName("자동차 게임 생성 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"k, y, j", "yongjin5184, pobi, pporotoss"})
    void initRacingCarTest(String carName) {
        RacingGame racingGame = RacingGame.create(new RandomMovingStrategy());
        racingGame.readyRacingCars(carName);
    }

    @DisplayName("자동차의 start 메소드 테스트")
    @ParameterizedTest
    @MethodSource("startRacingGame")
    void startRacingGame(String racingCarName, int time, boolean isMovable, int expected) {
        //given
        RacingGame racingGame = RacingGame.create(new StubMovingStrategyTest(isMovable));
        racingGame.readyRacingCars(racingCarName);

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
            Arguments.of("yongjin5184, pobi, pporotoss", 4, true, 4),
            Arguments.of("yongjin5184, pobi, pporotoss", 4, false, 0)
        );
    }

    @DisplayName("자동차 이름이 NULL 일 경우, throw IllegalArgumentException 을 실행")
    @ParameterizedTest
    @NullAndEmptySource
    void validateWhenCarNameIsNull(final String value) {
        RacingGame racingGame = RacingGame.create(new RandomMovingStrategy());
        assertThatThrownBy(() -> racingGame.readyRacingCars(value))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("경주할 자동차 이름을 반드시 입력해주세요.");
    }
}