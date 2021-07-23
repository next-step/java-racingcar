package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    private final ForwardConditionStrategy strategy = new NumberMoreThanFourConditionStrategy();

    @Test
    @DisplayName("정적_팩토리가_인스턴스를_생성하는지_확인한다")
    void from() throws Exception {
        RacingGame game = RacingGame.of(strategy, new int[]{3, 3});
        assertThat(game).isNotNull().isInstanceOf(RacingGame.class);
    }

    @Test
    @DisplayName("자동차와_시도할_회수는_3회씩_결과는_빈_문자열이_아닐것이다")
    void run() throws Exception {
        String actual = RacingGame.of(strategy, new int[]{3, 3}).run();
        assertThat(actual).isNotEmpty();
    }
}
