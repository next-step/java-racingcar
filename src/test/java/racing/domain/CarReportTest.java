package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("자동차 보고서(CarReport) 테스트")
public class CarReportTest {

    @DisplayName("자동차 보고서는 자동차 인덱스와 위치정보로 구성된다.")
    @ParameterizedTest
    @CsvSource({"1,4", "2,3"})
    void create(String name, int location) {
        // when
        CarReport carReport = CarReport.of(name, location);

        // then
        assertThat(carReport).isNotNull();
    }
}
