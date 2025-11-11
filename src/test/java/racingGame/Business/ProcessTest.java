package racingGame.Business;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingGame.Response.GameResult;
import racingGame.model.Car;
import racingGame.model.ProgressRecord;

import java.util.List;

class ProcessTest {
    
    Process gp;
    
    @BeforeEach
    void setUp() {
        gp = new Process();
    }

    @ParameterizedTest
    @CsvSource(value = {"pobi,crong:5", "pobi,crong:6"}, delimiter = ':')
    void carsForwardTest(String names, int moves) {
        String[] carsNames = names.split(",");
        List<ProgressRecord> progressRecords = gp.run(carsNames, moves);
        assertThat(progressRecords).hasSize(moves);
        assertThat(progressRecords)
                .allSatisfy(progressRecord ->
                        assertThat(progressRecord.carRecord()).hasSize(carsNames.length));
    }
}