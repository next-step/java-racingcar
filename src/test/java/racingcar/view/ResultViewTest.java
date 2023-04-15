package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultViewTest {


    @Test
    @DisplayName("repeat 함수 동작 테스트")
    void multiple_position_draw_check(){

        String DASH = "-";

        assertThat(DASH.repeat(0)).isEqualTo("");
        assertThat(DASH.repeat(1)).isEqualTo("-");
        assertThat(DASH.repeat(2)).isEqualTo("--");
        assertThat(DASH.repeat(3)).isEqualTo("---");
    }
}
