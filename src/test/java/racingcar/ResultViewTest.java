package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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

    @DisplayName("자동차의 이름과 위치를 함께 나타낸다")
    @ParameterizedTest(name = "{0} 이 {1} 칸이면 \"{2}\"")
    @CsvSource({"pobi,1,'pobi : -'", "crong,3,'crong : ---'", "honux,0,'honux : '"})
    void toLine(String name, int position, String expected) {
        assertThat(ResultView.toLine(new CarStatus(name, position))).isEqualTo(expected);
    }
}
