package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarGameTest {

    private final List<RacingCar> racingCars = new ArrayList<>();

    @BeforeEach
    void setUp() {
        for (int i = 0; i < 5; i++) {
            racingCars.add(new RacingCar());
        }
    }

    @Test
    void 랜덤값이_4이상_9이하이면_움직인다() {
        RacingCarGame racingCarGame = new RacingCarGame(racingCars, new AlwaysMoveStrategy());
        racingCarGame.play();
        for (RacingCar racingCar : racingCars) {
            assertThat(racingCar.getPosition())
                .withFailMessage("%d번째 인덱스에서 오류가 발생했습니다.", racingCars.indexOf(racingCar))
                .isEqualTo(1);
        }
    }

    @Test
    void 랜덤값이_0이상_3이하이면_멈춘다() {
        RacingCarGame racingCarGame = new RacingCarGame(racingCars, new AlwaysStopStrategy());
        racingCarGame.play();
        for (RacingCar racingCar : racingCars) {
            assertThat(racingCar.getPosition())
                .withFailMessage("%d번째 인덱스에서 오류가 발생했습니다.", racingCars.indexOf(racingCar))
                .isZero();
        }
    }
}