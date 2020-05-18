package race;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
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
    void startRacingGame() {

        int racingCarCount = 3;
        int time = 4;
        //given
        RacingGame racingGame = RacingGame.create(time, new StubMovingStrategyTest(true));
        racingGame.readyRacingCars(racingCarCount);

        //when
        racingGame.startRacing();
    }
}