package step3;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.racinggame.RacingGame;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingGameTest {
    private RacingGame racingGame;

    @BeforeEach
    void setUp() {
        racingGame = new RacingGame();
    }

    @Test
    @DisplayName("자동차 생성 테스트")
    void makeCarTestFunction() {
        racingGame.makeCar(3);
        int carCount = racingGame.getCars().size();
        assertThat(carCount).isEqualTo(3);
    }

    @Test
    @DisplayName("게임 생성 테스트")
    void racingGameCountTestFunction() {
        racingGame.setGameCount(6);
        int gameCount = racingGame.getGameCount();
        assertThat(gameCount).isEqualTo(6);
    }

    @Test
    @DisplayName("게임 종료 테스트")
    void racingGameIsEndTestFunction() {
        racingGame.makeCar(3);
        int gameCount = 5;
        racingGame.setGameCount(gameCount);
        for(int i = 0; i < gameCount; i++) {
            racingGame.play();
        }

        boolean isEnd = racingGame.isEnd();
        assertThat(isEnd).isEqualTo(true);
    }

}
