package racingcar.view;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowableOfType;

class RacingCarInputTest {

    @Test
    void carNameCsv가_빈_문자열이면_오류가_발생한다() {
        IllegalArgumentException e
            = catchThrowableOfType(() -> new RacingCarInput("", 10), IllegalArgumentException.class);

        assertThat(e).isNotNull();
        assertThat(e).hasMessage("자동차 이름을 입력하세요.");
    }

    @Test
    void tryCount가_2미만이면_오류가_발생한다() {
        IllegalArgumentException e
            = catchThrowableOfType(() -> new RacingCarInput("a,b,c,d", 1), IllegalArgumentException.class);

        assertThat(e).isNotNull();
        assertThat(e).hasMessage("시도 횟수는 2 이상이어야 합니다.");
    }
}
