package racingGame.Response;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingGame.model.ProgressRecord;

class GameResultTest {
    
    GameResult gameResult;
    
     @BeforeEach
     void setUp() {
         List<ProgressRecord> progressRecords = new ArrayList<>();
         progressRecords.add(new ProgressRecord());
         gameResult = new GameResult(progressRecords);
     }
    
    @Test
    void getGameResultTest() {
        assertThat(gameResult.progressRecords().size()).isEqualTo(1);
    }
}