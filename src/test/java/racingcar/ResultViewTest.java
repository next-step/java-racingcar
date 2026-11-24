package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

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

    @DisplayName("우승자가 한 명이면 그 이름을 알린다")
    @Test
    void toWinnerMessage() {
        assertThat(ResultView.toWinnerMessage(List.of("pobi")))
                .isEqualTo("pobi가 최종 우승했습니다.");
    }

    @DisplayName("우승자가 여럿이면 쉼표로 구분해 알린다")
    @Test
    void toWinnerMessageWithMultipleWinners() {
        assertThat(ResultView.toWinnerMessage(List.of("pobi", "honux")))
                .isEqualTo("pobi, honux가 최종 우승했습니다.");
    }
}
