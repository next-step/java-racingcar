package racingcar.ui;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowableOfType;
import static org.junit.jupiter.api.Assertions.*;

class RacingCarInputTest {

    @Test
    void carCount가_2미만이면_오류가_발생한다() {
        IllegalArgumentException e
            = catchThrowableOfType(() -> new RacingCarInput(1, 10), IllegalArgumentException.class);

        assertThat(e).isNotNull();
        assertThat(e).hasMessage("자동차는 2대 이상이어야 합니다.");
    }

    void tryCount가_2미만이면_오류가_발생한다() {
        IllegalArgumentException e
            = catchThrowableOfType(() -> new RacingCarInput(10, 1), IllegalArgumentException.class);

        assertThat(e).isNotNull();
        assertThat(e).hasMessage("시도 횟수는 2 이상이어야 합니다.");
    }
}
