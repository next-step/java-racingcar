package racing;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.domain.Competition;
import racing.ui.ResultView;

public class CompetitionTest {
    @ParameterizedTest
    @CsvSource({"1,1", "1,2", "2,3", "3,5"})
    void print(int unit, int count) {
        Competition competition = new Competition(unit, count);
        ResultView.print(competition);
    }
}
