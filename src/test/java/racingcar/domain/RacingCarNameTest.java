package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowableOfType;

class RacingCarNameTest {

    @Test
    void 생성_성공한다() {
        new RacingCarName("123");
    }

    @Test
    void 생성_실패한다() {
        IllegalArgumentException e = catchThrowableOfType(() ->
            new RacingCarName("123456"), IllegalArgumentException.class);

        assertThat(e).isNotNull();
        assertThat(e).hasMessage("자동차 이름은 5자를 초과할 수 없습니다.");
    }

}
