package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarNamesTest {

    @DisplayName("getRacingCarNames 메소드 테스트")
    @Test
    void getRacingCarNames() {
        String car1 = "car1";
        String car2 = "car2";
        RacingCarNames racingCarNames = new RacingCarNames(car1, car2);
        Assertions.assertThat(racingCarNames.getRacingCarNames()).containsExactly(car1, car2);
    }

    @DisplayName("length 메소드 테스트")
    @Test
    void length() {
        String car1 = "car1";
        String car2 = "car2";
        RacingCarNames racingCarNames = new RacingCarNames(car1, car2);
        Assertions.assertThat(racingCarNames.length()).isEqualTo(2);
    }

    @DisplayName("빈 배열을 입력받을 경우 IllegalArgumentException")
    @Test
    void illegalArgumentExceptionTest() {
        Assertions.assertThatThrownBy(RacingCarNames::new)
                .isInstanceOf(IllegalArgumentException.class);
    }
}