package racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    private NumberMoreThanFourConditionStrategy strategy = NumberMoreThanFourConditionStrategy.getInstance();

    @Test
    @DisplayName("정적_팩토리가_인스턴스를_생성하는지_확인한다")
    void from() throws Exception {
        RacingGame game = RacingGame.of(strategy, 3, 3);
        assertThat(game).isNotNull().isInstanceOf(RacingGame.class);
    }

    @Test
    @DisplayName("자동차와_시도할_회수는_3회씩_결과_문자열은_1글자_이상일_것이다")
    void run() throws Exception {
        String actual = RacingGame.of(strategy, 3, 3).run();
        assertThat(actual.length()).isGreaterThanOrEqualTo(1);
    }

    @Test
    @DisplayName("자동차는_반드시_2대_이상이어야_한다")
    void racerCountException() throws Exception {
        Assertions.assertThatThrownBy(() -> RacingGame.of(strategy, 1, 2))
                  .isInstanceOf(IllegalArgumentException.class)
                  .hasMessage("자동차는 2대 이상이어야 합니다");
    }

    @Test
    @DisplayName("스테이지는_반드시_1_이상이어야_한다")
    void stageCountException() throws Exception {
        Assertions.assertThatThrownBy(() -> RacingGame.of(strategy, 2, 0))
                  .isInstanceOf(IllegalArgumentException.class)
                  .hasMessage("시도 횟수는 1회 이상이어야 합니다");
    }
}
