package racingGame.model;

import static org.assertj.core.api.Assertions.assertThat;

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
        assertThat(progressRecord.gameResult()).isEmpty();
    }
    
    @Test
    void gameRecordTest() {
        progressRecord.gameRecord(new Car());
        progressRecord.gameRecord(new Car());
        assertThat(progressRecord.gameRecord(new Car()).size()).isEqualTo(3);
    }
    
    @Test
    void showGameResultTest() {
        progressRecord.gameRecord(new Car());
        progressRecord.gameRecord(new Car());
        assertThat(progressRecord.gameResult()).isNotEmpty();
    }
}