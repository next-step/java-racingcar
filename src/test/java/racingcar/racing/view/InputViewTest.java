package racingcar.racing.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

class InputViewTest {
    @DisplayName("input 테스트, 유효하지 않은 문자열은 정상 범위 숫자가 나올 때까지 next")
    @Test
    public void validInput() {
        System.setIn(new ByteArrayInputStream("a\n5\n-5\n3\n".getBytes()));

        Assertions.assertThat(InputView.getUserInput("자동차 대수는 몇 대 인가요?")).isEqualTo(5);
        Assertions.assertThat(InputView.getUserInput("시도할 회수는 몇 회 인가요?")).isEqualTo(3);

        System.setIn(System.in);
    }
}