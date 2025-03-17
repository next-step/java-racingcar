package racing;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racing.Reports.ScoreBoard;

class ReportsTest {

    @Test
    @DisplayName("생성자 테스트")
    void constructorTest() {
        // given
        var testCars = List.of(new Car(), new Car());

        // when
        var reports = new Reports(testCars);

        // then
        Assertions.assertThat(reports.getReports().size()).isEqualTo(testCars.size());
        reports.getReports().forEach(report -> Assertions.assertThat(report.getPosition()).isEqualTo(0));
    }

    @Test
    @DisplayName("파라미터로 전달된 방법으로 print한다.")
    void printTest() {
        // given
        var testCars = List.of(new Car(), new Car());
        var reports = new Reports(testCars);
        var mockPrintStrategy = new MockScoreBoard();

        // when
        reports.print(mockPrintStrategy);

        // then
        Assertions.assertThat(mockPrintStrategy.getSize()).isEqualTo(testCars.size());
        reports.getReports().forEach(score -> Assertions.assertThat(score).isEqualTo(0));
    }

    static class MockScoreBoard implements ScoreBoard {
        private final List<Integer> scores = new ArrayList<>();

        @Override
        public void print(int position) {
            scores.add(position);
        }

        int getSize() {
            return scores.size();
        }
    }
}
