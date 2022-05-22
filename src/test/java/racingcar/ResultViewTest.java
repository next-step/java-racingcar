package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultViewTest extends ResultView {

    @Test
    void 포지션_문자로_출력() {
        assertThat(appendPosition(3)).isEqualTo("---");
    }
}
