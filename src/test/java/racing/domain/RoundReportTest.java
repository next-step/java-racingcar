package racing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

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

    @DisplayName("판의 우승자들을 구할 수 있다.")
    @Test
    void winner() {
        // given
        roundReport = RoundReport.of(Arrays.asList(
                CarReport.of("a", 10),
                CarReport.of("b", 5),
                CarReport.of("c", 10)
        ));
        // when
        List<String> winners = roundReport.winner();

        // then
        assertThat(winners).contains("a", "c");
    }
}
