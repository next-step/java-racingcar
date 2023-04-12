package study.racing;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import study.racing.controller.RacingGame;
import study.racing.view.InputView;
import study.racing.view.ResultView;

public class InstanceTest {

    @Test
    void 인스턴스_테스트() {
        InputView inputView1 = InputView.getInstance();
        InputView inputView2 = InputView.getInstance();

        ResultView resultView1 = ResultView.getInstance();
        ResultView resultView2 = ResultView.getInstance();

        RacingGame racingGame1 = RacingGame.getInstance();
        RacingGame racingGame2 = RacingGame.getInstance();

        Assertions.assertThat(inputView1).isSameAs(inputView2);
        Assertions.assertThat(resultView1).isSameAs(resultView2);
        Assertions.assertThat(racingGame1).isSameAs(racingGame2);
    }
}
