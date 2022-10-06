package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.view.ConsoleResultView;
import racingcar.view.ResultView;

import java.util.stream.IntStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class GameTest {

    @Test
    @DisplayName("게임 완료 후 모든 차가 0~round 위치에 있어야 한다")
    void test() {
        String[] names = IntStream.range(0, 50)
                .mapToObj(number -> "car" + number)
                .toArray(String[]::new);
        int round = 100;
        ResultView resultView = new ConsoleResultView();

        Game game = new Game(names, round, resultView);
        game.start();

        game.getCars()
                .forEach(car -> assertThat(car.getPosition()).isBetween(0, round));
    }
}
