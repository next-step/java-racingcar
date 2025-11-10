package racingGame.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProgressRecordTest {
    
    ProgressRecord progressRecord;
    
    @BeforeEach
    void setUp() {
        progressRecord = new ProgressRecord();
    }
    
    @Test
    void recordIsEmptyTest() {
        assertThat(progressRecord.carRecord()).isEmpty();
    }
    
    @Test
    void gameRecordTest() {
        List<Car> joinCarsRecord = new ArrayList<>();
        joinCarsRecord.add(new Car());
        joinCarsRecord.add(new Car());
        joinCarsRecord.add(new Car());
        
        assertThat(progressRecord.recordGame(joinCarsRecord).size()).isEqualTo(3);
    }
    
    @Test
    void showGameResultTest() {
        List<Car> joinCarsRecord = new ArrayList<>();
        joinCarsRecord.add(new Car());
        joinCarsRecord.add(new Car());
        progressRecord.recordGame(joinCarsRecord);
        assertThat(progressRecord.carRecord()).isNotEmpty();
    }
}