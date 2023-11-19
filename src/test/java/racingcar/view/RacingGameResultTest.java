package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.RacingCar;
import racingcar.view.RacingGameResult;

public class RacingGameResultTest {

    @Test
    @DisplayName("자동차 게임 실행 결과를 알려준다.")
    void game_result() {
        // given
        RacingGameResult gameResult = new RacingGameResult();
        List<RacingCar> racingCars = createRacingCars();

        // when
        String result = gameResult.create(racingCars);

        // then
        assertThat(result).isEqualTo(
                "-\n"
                        + "--\n"
                        + "---\n"
                        + "\n");
    }

    private List<RacingCar> createRacingCars() {
        return Arrays.asList(
                new RacingCar(1),
                new RacingCar(2),
                new RacingCar(3)
        );
    }
}
