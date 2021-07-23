package racingGame;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultViewTest {

    @Test
    @DisplayName("입력받은 숫자 갯수만큼 - String 반환한다.")
    void parseIntegerToBar() {
        String result = ResultView.parseIntegerToBar(3);
        Assertions.assertThat(result).isEqualTo("---");
    }
}
