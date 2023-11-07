package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.Car;
import step3.domain.Position;
import step3.domain.RacingGame;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class RacingGameTest {

    private static final String[] NAME_OF_CARS = {"pobi", "crong", "honux"};
    private static final int NUMBER_OF_TRY = 5;

    @Test
    @DisplayName("게임 실행 후 자동차의 위치를 확인한다")
    public void 게임_결과() {
        // given
        List<Car> cars = CarGenerator.generate(NAME_OF_CARS);
        RacingGame game = new RacingGame(cars, NUMBER_OF_TRY);

        // when
        for (int round = 0; !game.isEnd(round); round++) {
            game.playRound();
        }

        // then
        assertThat(cars).allSatisfy(car -> {
            Position position = car.position();
            assertThat(position.position()).isBetween(0, NUMBER_OF_TRY);
        });
    }

}
