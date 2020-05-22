package study.nextstep.stage4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class RacingGameTest {
    @Test
    public void simpleRacingGameRunTest() {
        RacingGame game = new RacingGame(new InputView() {
            @Override
            public String[] getNames() {
                return "pobi,crong,honux".split(",");
            }

            @Override
            public int getCount() {
                return 5;
            }
        });
        game.run(new DefaultStandardIORenderer());
    }

    @Test
    public void randomModuleMaximzedGameRunTest() {
        RacingGame game = new RacingGame(new InputView() {
            @Override
            public String[] getNames() {
                return "runner".split(",");
            }

            @Override
            public int getCount() {
                return 4;
            }
        }).randomModule(new Random(){
            @Override
            public int nextInt(int bound) {
                return bound - 1;
            }
        });
        game.run(new Renderer() {
            int runningStatus = 2;
            @Override
            public void render(String[] names, GameStatus status) {
                assertThat(names[0]).isEqualTo("runner");
                assertThat(status.getPosition(0)).isEqualTo(runningStatus);
                runningStatus++;
            }

            @Override
            public void renderFirstStatus(GameStatus status) {

            }

            @Override
            public void renderWinner(String[] names, GameStatus status) {
                assertThat(status.getWinnerNames(names)).isEqualTo("runner");
            }
        });
        // assert
    }

    @DisplayName("random값에 따른 움직임 결과 확인")
    @Test
    public void positionMoveTest() {
        GameStatus status = new GameStatus(1);
        status.totalTurn(new Random() {
            @Override
            public int nextInt(int bound) {
                return bound - 1;
            }
        });
        assertThat(status.getPosition(0)).isEqualTo(2);

        status.totalTurn(new Random() {
            @Override
            public int nextInt(int bound) {
                return 0;
            }
        });
        assertThat(status.getPosition(0)).isEqualTo(2);
    }

    @DisplayName("position call 잘못 되었을 때 Exception 확인")
    @Test
    public void positionExceptionTest() {
        GameStatus status = new GameStatus(1);
        assertThatIllegalArgumentException().isThrownBy(() -> status.getPosition(3));
    }
}
