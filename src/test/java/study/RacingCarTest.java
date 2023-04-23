package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarTest {

    RacingCar racingCar = new RacingCar();

    @Test
    @DisplayName("사용자에게 특정 메세지를 보여주는 기능")
    void showMessage() {
        Assertions.assertThat(racingCar.questionMessage("TRY")).isEqualTo("시도할 회수는 몇 회 인가요?");
        Assertions.assertThat(racingCar.questionMessage("CAR")).isEqualTo("자동차 대수는 몇 대 인가요?");
        Assertions.assertThat(racingCar.questionMessage("A")).isEqualTo("NO MESSAGE");
    }

}
