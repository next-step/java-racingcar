package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultViewTest {
    @Test
    void shouldCreateTrack() {
        String actual = ResultView.createTrack(3);
        String expected = "---";
        assertThat(actual).isEqualTo(expected);
    }
}
