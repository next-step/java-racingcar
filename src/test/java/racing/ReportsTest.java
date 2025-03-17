package racing;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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


}
