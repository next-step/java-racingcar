package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.view.RacingCarOutView;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class RacingCarTest {
    @Test
    void racingTest() {
        RacingCar racingCar = new RacingCar(new Cars(3), 5);
        racingCar.start();
        Cars cars = racingCar.getCars();
        RacingResult result = cars.getRacingResult();
        RacingCarOutView.showResult(result.racingRounge());
    }

    @Test
    @DisplayName("주어진 횟수 최소 1회 검증")
    void validMinCount() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new RacingCar(new Cars(3), 0);
        })
                .withMessageContaining("주어진 횟수는 최소 1번입니다.");

    }

}
