package racing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("판 보고서(RoundReport) 테스트")
public class RoundReportTest {

    private RoundReport roundReport;

    @BeforeEach
    void setUp() {
        roundReport = RoundReport.of(Arrays.asList(
                CarReport.of("1", 10),
                CarReport.of("2", 5),
                CarReport.of("3", 2)
        ));
    }

    @DisplayName("판 보고서는 자동차 보고서들로 구성된다.")
    @Test
    void create() {
        // when / then
        assertThat(roundReport).isNotNull();
    }
}
