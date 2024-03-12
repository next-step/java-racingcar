package step3and4;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingTest {

    @DisplayName("참가하는 자동차와, 시도횟수를 입력받을 수 있다.")
    @Test
    void createRacing() {
        Racing racing = Racing.createRacing(3, 5);
        int carNumber = racing.getCarNumberOfParticipants();
        int tryNumber = racing.getTryNumber();
        Assertions.assertThat(carNumber).isEqualTo(3);
        Assertions.assertThat(tryNumber).isEqualTo(5);
    }
}
