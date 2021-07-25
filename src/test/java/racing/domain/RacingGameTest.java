package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.strategy.NumberMoreThanFourConditionStrategy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingGameTest {
    private final NumberMoreThanFourConditionStrategy strategy = NumberMoreThanFourConditionStrategy.getInstance();

    @Test
    @DisplayName("정적_팩토리가_인스턴스를_생성하는지_확인한다")
    void from() throws Exception {
        RacingGame game = RacingGame.init(strategy, "pobi,crong,honux", 3);
        assertThat(game).isNotNull().isInstanceOf(RacingGame.class);
    }

    @Test
    @DisplayName("자동차와_시도할_회수는_3회씩_결과_크기는_3")
    void run() throws Exception {
        int actual = RacingGame.init(strategy, "pobi,crong,honux", 3).run().size();
        assertThat(actual).isGreaterThanOrEqualTo(3);
    }

    @Test
    @DisplayName("자동차는_반드시_2대_이상이어야_한다")
    void racerCountExceptionV1() throws Exception {
        assertThatThrownBy(() -> RacingGame.init(strategy, "pobi", 2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 2개 이상이어야 하고, 공백이 있으면 안되며 쉼표(,)로 구분되어야 합니다.");
    }

    @Test
    @DisplayName("자동차는_반드시_2대_이상이어야_한다_아무것도_입력하지_않은_경우")
    void racerCountExceptionV2() throws Exception {
        assertThatThrownBy(() -> RacingGame.init(strategy, null, 2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 2개 이상이어야 하고, 공백이 있으면 안되며 쉼표(,)로 구분되어야 합니다.");
    }

    @Test
    @DisplayName("쉼표만_입력한_경우")
    void racerCountExceptionV3() throws Exception {
        assertThatThrownBy(() -> RacingGame.init(strategy, ",", 2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 2개 이상이어야 하고, 공백이 있으면 안되며 쉼표(,)로 구분되어야 합니다.");
    }

    @Test
    @DisplayName("공백이_입력된_경우")
    void racerCountExceptionV4() throws Exception {
        assertThatThrownBy(() -> RacingGame.init(strategy, " , ", 2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 2개 이상이어야 하고, 공백이 있으면 안되며 쉼표(,)로 구분되어야 합니다.");
    }

    @Test
    @DisplayName("자동차_이름이_중복된_경우")
    void racerCountExceptionV5() throws Exception {
        assertThatThrownBy(() -> RacingGame.init(strategy, "pobi,pobi", 2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 중복 될 수 없습니다.");
    }

    @Test
    @DisplayName("스테이지는_반드시_1_이상이어야_한다")
    void stageCountException() throws Exception {
        assertThatThrownBy(() -> RacingGame.init(strategy, "pobi,crong,honux", 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 1회 이상이어야 합니다");
    }
}
