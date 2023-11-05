package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class RacingGameTest {

    private static final int NUMBER_OF_CAR = 3;
    private static final int NUMBER_OF_TRY = 5;

    @Test
    @DisplayName("게임 실행 후 자동차의 위치를 확인한다")
    public void 게임_결과() {
        // given
        List<Car> cars = CarGenerator.generate(NUMBER_OF_CAR);
        RacingGame game = new RacingGame(cars, NUMBER_OF_TRY);

        // when
        game.play();

        // then
        assertThat(cars).allSatisfy(car -> {
            assertThat(car.position()).isBetween(0, NUMBER_OF_TRY);
        });
    }

}
