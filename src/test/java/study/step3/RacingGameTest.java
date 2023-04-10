package study.step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class RacingGameTest {

    private RacingGame racingGame;

    @BeforeEach
    void setUp() {
        racingGame = new RacingGame();
        racingGame.readyGame(3);
    }

    @Test
    void 게임준비_모든차_위치_0_테스트() {

        racingGame.getCarList().forEach(
                car -> assertThat(car.getPosition())
                        .isEqualTo(0)
        );
    }

    @Test
    void 게임시작_모든차_위치_시도횟수_이히_테스트() {

        racingGame.startGame(3);

        racingGame.getCarList().stream().forEach(
                car -> assertThat(car.getPosition())
                        .isLessThan(4)
        );
    }
}
