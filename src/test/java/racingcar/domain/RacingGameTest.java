package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.movable.FixedForwardStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.view.ResultView;

import static org.assertj.core.api.Assertions.*;

class RacingGameTest {

    RacingGame racingGame;
    List<String> carNames;

    @BeforeEach
    void setUp() {
        carNames = new ArrayList<>(Arrays.asList("c", "java", "jpa"));
        racingGame = RacingGame.from(Cars.of(carNames, new FixedForwardStrategy(true)));
    }

    @Test
    void 가장_많이_전진한_자동차가_우승한다() {
        racingGame.drive(3, ResultView.instance());
        assertThat(racingGame.judgeWinners().getResult()).containsExactly("c", "java", "jpa");
    }

    @Test
    void 아무도_전진하지_못했다면_우승자는_없다() {
        assertThat(racingGame.judgeWinners().getResult().size()).isEqualTo(0);
    }

    @Test
    void 자동차를_등록할_수_있다() {
        Cars cars = Cars.instance();
        racingGame = RacingGame.from(cars);
        racingGame.registerCars(carNames);
        assertThat(cars.getCars().size()).isEqualTo(3);
    }

}
