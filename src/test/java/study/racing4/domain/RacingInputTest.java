package study.racing4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.racing4.domain.RacingInput;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class RacingInputTest {

    @Test
    @DisplayName("정상적으로 자동차 수 반환되는지 확인")
    void 자동차_수_확인() {

        RacingInput input = new RacingInput("pobi,cron,honux", 3);
        assertThat(input.getCars().length).isEqualTo(3);
    }

    @Test
    @DisplayName("정상적으로 라운드 수 반환되는지 확인")
    void 라운드_수_확인() {

        RacingInput input = new RacingInput("pobi,cron,honux", 3);

        assertThat(input.getCountOfRound()).isEqualTo(3);
    }

    @Test
    @DisplayName("입력문자열이 없으면 에러")
    void 자동차_입력_문자열_공백_확인()
    {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    RacingInput input = new RacingInput("", 3);
                }).withMessageContaining("자동차 이름 입력값이 비어 있습니다.");
    }

    @Test
    @DisplayName("라운드 수가 0보다 작다면 예외발생")
    void 라운드_수_예외_발생()
    {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    RacingInput input = new RacingInput("pobi,cron,honux", 0);
                }).withMessageContaining("라운드 수는 0 보다 커야합니다.");
    }

}
