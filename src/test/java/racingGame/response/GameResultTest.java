package racingGame.response;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingGame.model.Car;
import racingGame.model.GameResult;
import racingGame.model.ProgressRecord;

class GameResultTest {
    
    GameResult gameResult;
    
    @Test
    void getGameResultTest() {
        List<Car> cars = new ArrayList<>();
        
        List<ProgressRecord> progressRecords = new ArrayList<>();
        progressRecords.add(new ProgressRecord(cars));
        gameResult = new GameResult(progressRecords);
        assertThat(gameResult.progressRecords().size()).isEqualTo(1);
    }
}