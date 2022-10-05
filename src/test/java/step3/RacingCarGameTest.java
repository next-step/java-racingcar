package step3;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarGameTest {

    @Test
    @DisplayName("인자로 입력받은 수와 자동차 대수가 일치하는지 검사한다")
    void checkNumberOfCars() {
        RacingCarGame racingCarGame = new RacingCarGame();
        List<Car> cars =  racingCarGame.makeCars(5);
        assertThat(cars.size()).isEqualTo(5);
    }
}
