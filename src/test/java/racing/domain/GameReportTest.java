package racing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("게임 보고서(GameReport) 테스트")
public class GameReportTest {

    private GameReport gameReport;

    @BeforeEach
    void setUp() {
        gameReport = GameReport.of(Arrays.asList(
                RoundReport.of(Arrays.asList(
                        CarReport.of("1", 4),
                        CarReport.of("2", 5),
                        CarReport.of("3", 6))),
                RoundReport.of(Arrays.asList(
                        CarReport.of("1", 6),
                        CarReport.of("2", 7),
                        CarReport.of("3", 7)
                ))
        ));
    }

    @DisplayName("게임 보고서는 판 보고서로 구성된다.")
    @Test
    void create() {
        // when / then
        assertThat(gameReport).isNotNull();
    }

    @DisplayName("게임의 우승자들을 구할 수 있다.")
    @Test
    void winner() {
        // when
        List<String> winners = gameReport.winner();

        // then
        assertThat(winners).contains("2", "3");
    }
}
