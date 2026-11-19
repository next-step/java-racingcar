package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class ResultViewTest {

    @DisplayName("자동차의 위치를 - 개수로 나타낸다")
    @ParameterizedTest(name = "위치가 {0} 이면 {1}")
    @CsvSource({"0,''", "1,'-'", "3,'---'"})
    void toDashes(int position, String expected) {
        assertThat(ResultView.toDashes(position)).isEqualTo(expected);
    }
}
