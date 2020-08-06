package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.ui.InputAvailable;
import racingcar.ui.InputView;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @DisplayName("게임 진행 중 오류 미발생")
    @Test
    public void game() {

        InputView inputView = makeInputView();

        RacingGame racingGame = new RacingGame(RacingData.of(inputView),
                new Engine(() -> 5));
        racingGame.run();
        racingGame.result();

        assertThat(racingGame.getWinnerNames()).isEqualTo("a, b, c");
    }

    private InputView makeInputView() {
        return new InputView(new InputAvailable() {
            @Override
            public String inputNames() {
                return "a,b,c";
            }

            @Override
            public int inputNumberOfCars() {
                return 3;
            }

            @Override
            public int inputTryCount() {
                return 5;
            }
        });
    }
}
