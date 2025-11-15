package racingGame.business;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingGame.response.GameFinalResult;
import racingGame.response.GameResult;

import java.util.List;

class ProcessTest {
    
    Process gp;
    
    @BeforeEach
    void setUp() {
        gp = new Process();
    }
    
    @ParameterizedTest
    @CsvSource(value = {"pobi,crong:5", "pobi,crong:6"}, delimiter = ':')
    void carsMoveCountTest(String names, int moves) {
        String[] carsNames = names.split(",");
        GameFinalResult gameFinalResult =  gp.run(carsNames, moves);
        List<GameResult> gameResults = gameFinalResult.gameResult();
        
        assertThat(gameResults)
            .allSatisfy(gameResult ->
                assertThat(gameResult.progressRecords()).hasSize(moves));
    }
    
    @ParameterizedTest
    @CsvSource(value = {"pobi,crong:5", "pobi,crong:6"}, delimiter = ':')
    void carsCountTest(String names, int moves) {
        String[] carsNames = names.split(",");
        GameFinalResult gameFinalResult =  gp.run(carsNames, moves);
        List<GameResult> gameResults = gameFinalResult.gameResult();
        
        assertThat(gameResults)
            .allSatisfy(gameResult ->
                assertThat(gameResult.progressRecords())
                    .allSatisfy(progressRecord ->
                        assertThat(progressRecord.joinCars()).hasSize(carsNames.length)
                    ));
    }
}