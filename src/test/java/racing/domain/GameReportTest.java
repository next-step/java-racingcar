package racing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("게임 보고서(GameReport) 테스트")
public class GameReportTest {

    private GameReport gameReport;

    @BeforeEach
    void setUp() {
        gameReport = GameReport.of(Arrays.asList(
                RoundReport.of(Arrays.asList(CarReport.of("1", 3))),
                RoundReport.of(Arrays.asList(CarReport.of("1", 3))),
                RoundReport.of(Arrays.asList(CarReport.of("1", 3)))
        ));
    }

    @DisplayName("게임 보고서는 판 보고서(RoundReport)로 구성된다.")
    @Test
    void create() {
        // when / then
        assertThat(gameReport).isNotNull();
    }

}
