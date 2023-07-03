package racing.view;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RacingViewTest {
    @Test
    void getAskingCarNameViewTest() {
        RacingView racingView = new RacingView();
        String text = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";

        assertThat(racingView.getAskingCarNameView()).isEqualTo(text);
    }

    @Test
    void getAskingCountViewTest() {
        RacingView racingView = new RacingView();
        String text = "시도할 회수는 몇회인가요?";

        assertThat(racingView.getAskingCountView()).isEqualTo(text);
    }

    @Test
    void getResultTitleViewTest() {
        RacingView racingView = new RacingView();
        String text = "실행 결과";

        assertThat(racingView.getResultTitleView()).isEqualTo(text);
    }
}