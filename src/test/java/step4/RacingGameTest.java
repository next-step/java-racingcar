package step4;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.racinggame.RacingGame;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingGameTest {
    private RacingGame racingGame;

    @BeforeEach
    void setUp() {
        int gameCount = 5;
        String[] carArr = {"carA","carB","carC"};
        racingGame = new RacingGame(gameCount ,carArr);
    }

    @Test
    @DisplayName("자동차 생성 테스트")
    void makeCarTestFunction() {
        int carCount = racingGame.getCars().size();
        assertThat(carCount).isEqualTo(3);
    }

    @Test
    @DisplayName("게임 생성 테스트")
    void racingGameCountTestFunction() {
        int gameCount = racingGame.getGameCount();
        assertThat(gameCount).isEqualTo(5);
    }

    @Test
    @DisplayName("게임 종료 테스트")
    void racingGameIsEndTestFunction() {
        for(int i = 0; i < racingGame.getGameCount(); i++) {
            racingGame.play();
        }

        boolean isEnd = racingGame.isEnd();
        assertThat(isEnd).isEqualTo(true);
    }
}
