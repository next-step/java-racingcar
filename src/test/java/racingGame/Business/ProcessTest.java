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
    @CsvSource(value = {"3:5", "4:6"}, delimiter = ':')
    void carsForwardTest(int cars, int moves) {
        List<ProgressRecord> progressRecords = gp.run(cars, moves);
        assertThat(progressRecords).hasSize(moves);
        assertThat(progressRecords)
                .allSatisfy(progressRecord ->
                        assertThat(progressRecord.carRecord()).hasSize(cars));
    }
}