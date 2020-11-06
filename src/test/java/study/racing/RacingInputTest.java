package study.racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class RacingInputTest {

    @Test
    @DisplayName("정상적으로 자동차 수 반환되는지 확인")
    void 자동차_수_확인() {

        RacingInput input = new RacingInput(5, 3);

        assertThat(input.getCountOfCar()).isEqualTo(5);
    }

    @Test
    @DisplayName("정상적으로 라운드 수 반환되는지 확인")
    void 라운드_수_확인() {

        RacingInput input = new RacingInput(5, 3);

        assertThat(input.getCountOfRound()).isEqualTo(3);
    }

    @Test
    @DisplayName("자동차 수가 0보다 작다면 예외발생")
    void 예외가_발생()
    {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    RacingInput input = new RacingInput(-1, 3);
                }).withMessageContaining("자동차 수는 0 보다 커야합니다.");
    }

}
