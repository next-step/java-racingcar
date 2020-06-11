package autoracing.view;

import autoracing.domain.RacingGame;
import org.junit.jupiter.api.Test;

import static autoracing.domain.CarTest.makeCars;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

public class ResultViewTest {
    @Test
    public void builderTest() {
        assertThatNullPointerException().isThrownBy(() -> {
            new ResultView.Builder(null);
        }).withMessage("racingGame must be not null.");

        RacingGame game = new RacingGame(1, makeCars("Neo"));
        ResultView.Builder builder = new ResultView.Builder(game);

        assertThatNullPointerException().isThrownBy(() -> {
            builder.resultTitle(null);
        }).withMessage("resultTitle must be not null.");
        assertThatNullPointerException().isThrownBy(() -> {
            builder.winnersRenderer(null);
        }).withMessage("winnersRenderer must be not null.");
        assertThatNullPointerException().isThrownBy(() -> {
            builder.carTrackRenderer(null);
        }).withMessage("carTrackRenderer must be not null.");

        assertThatCode(() -> {
            ResultView defaultView = builder.build();
            ResultView expectedView = new ResultView.Builder(game)
                    .resultTitle("실행 결과")
                    .winnersRenderer(new WinnersRenderer("%s가 최종 우승했습니다.", ", "))
                    .carTrackRenderer(new CarTrackRenderer("-", " : ", "-"))
                    .build();
            assertThat(defaultView).isEqualToComparingFieldByField(expectedView);
        }).doesNotThrowAnyException();
    }
}
