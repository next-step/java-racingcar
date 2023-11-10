package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.strategy.RandomMoveStrategyTest;

class RacingGameTest {

    private RacingGame racingGame;

    @BeforeEach
    void setUp() {
        String carsName = "a,b,c";
        int tryCount = 5;
        racingGame = new RacingGame(new Cars(carsName), tryCount);
        for (int i = 0; i < tryCount; i++) {
            racingGame.start(new RandomMoveStrategyTest(6));
        }
    }

    @Test
    @DisplayName("입력받은 횟수 만큼 racing 수행 후 종료 확인")
    void racingGame_종료확인() {
        assertThat(racingGame.isEndGame()).isEqualTo(true);
    }

    @Test
    @DisplayName("racingGame 시작 횟수 차감되는 지 확인")
    void racingGame_시작확인() {
        assertThat(racingGame.cars().carList().size()).isGreaterThan(0);
    }

    @Test
    @DisplayName("cars반환을 확인")
    void racingGame_cars반환확인() {
        assertThat(racingGame.cars()).isNotNull();
        assertThat(racingGame.cars()).isInstanceOf(Cars.class);
    }
}