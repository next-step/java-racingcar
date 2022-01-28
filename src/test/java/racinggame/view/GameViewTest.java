package racinggame.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racinggame.domain.Judge;
import racinggame.domain.RacingCars;

class GameViewTest {

    private RacingCars racingCars;
    private GameView gameView;

    @BeforeEach
    void before() {
        racingCars = new RacingCars("car1,car2");
        racingCars.getRacingCars().get(0).forward();
        racingCars.getRacingCars().get(1).forward();
        racingCars.getRacingCars().get(1).forward();

        gameView = new GameView(racingCars);
    }

    @Test
    void 상태를_출력할_자동차_리스트를_받아_생성한다() throws NoSuchFieldException, IllegalAccessException {

        // when
        Field racingCarViewsField = GameView.class.getDeclaredField("carResultViews");
        racingCarViewsField.setAccessible(true);

        List<CarResultView> racingCarViews = (List<CarResultView>) racingCarViewsField.get(gameView);
        // then

        assertThat(racingCarViews.size()).isEqualTo(2);
    }

    @Test
    void 현재_자동차들의_상태를_저장한다() {

        // when
        gameView.saveProgress();

        // then

        assertThat(gameView.result.toString()).contains("car1 : -");
        assertThat(gameView.result.toString()).contains("car2 : --");
    }

    @Test
    void 게임_결과를_출력한다() {

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        // when
        gameView.saveProgress();
        gameView.printResult();

        // then
        assertThat(out.toString()).contains("car1 : -");
        assertThat(out.toString()).contains("car2 : --");
    }

    @Test
    void 우승자를_출력한다() {

        //when
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        gameView.printWinners(Judge.getWinners(racingCars));

        //then
        assertThat(out.toString()).contains("car2");
    }
}
