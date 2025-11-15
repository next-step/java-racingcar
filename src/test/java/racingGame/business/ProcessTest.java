package racingGame.business;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingGame.response.GameResponse;
import racingGame.model.GameResult;

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
        GameResponse gameResponse =  gp.run(carsNames, moves);
        GameResult gamedResult = gameResponse.gameResult();
        
        assertThat(gamedResult.progressRecords()).hasSize(moves);
    }
    
    @ParameterizedTest
    @CsvSource(value = {"pobi,crong:5", "pobi,crong:6"}, delimiter = ':')
    void carsCountTest(String names, int moves) {
        String[] carsNames = names.split(",");
        GameResponse gameResponse =  gp.run(carsNames, moves);
        GameResult gamedResult = gameResponse.gameResult();
        
        assertThat(gamedResult.progressRecords())
            .allSatisfy(progressRecord ->
                assertThat(progressRecord.joinCars()).hasSize(carsNames.length)
            );
    }
}