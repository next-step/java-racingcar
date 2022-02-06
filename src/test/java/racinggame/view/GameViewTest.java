package racinggame.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racinggame.domain.Judge;
import racinggame.domain.RacingCar;
import racinggame.domain.RacingCars;
import racinggame.domain.vo.WinnersVo;

class GameViewTest {

    private RacingCars racingCars;

    @BeforeEach
    void before() {
        RacingCar car1 = new RacingCar("car1", 1);
        RacingCar car2 = new RacingCar("car2", 2);
        racingCars = new RacingCars(Arrays.asList(car1, car2));
        GameView.init(racingCars);
    }

    @Test
    void 현재_자동차들의_상태를_저장한다() {
        // when
        GameView.saveProgress(racingCars);

        // then

        assertThat(GameView.result.toString()).contains("car1 : -");
        assertThat(GameView.result.toString()).contains("car2 : --");
    }

    @Test
    void 게임_결과를_출력한다() {
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        // when
        GameView.saveProgress(racingCars);
        GameView.printResult();

        // then
        assertThat(out.toString()).contains("car1 : -");
        assertThat(out.toString()).contains("car2 : --");
    }

    @Test
    void 우승자를_출력한다() {
        //when
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        GameView.printWinners(new WinnersVo(Judge.getWinners(racingCars)));

        //then
        assertThat(out.toString()).contains("car2");
    }
}
