package study.racing;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.LinkedList;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class RacingGameRoundsTest {

    @DisplayName("recording 메소드 테스트")
    @Test
    void recordingTest(){
        int carCnt = 1;

        Cars cars = new Cars(carCnt);

        LinkedList<Integer> positionList = new LinkedList<>();
        positionList.add(cars.getCarSet().get(0).getPosition());

        RacingRecord racingRecord = new RacingRecord(positionList);
        RacingRecords racingRecords = new RacingRecords();
        racingRecords.addRecord(racingRecord);

        assertEquals(carCnt, racingRecords.getRecordList().size());
    }

    @DisplayName("각 라운드 종료 후 남은 라운드 개수 비교 테스트")
    @ParameterizedTest
    @CsvSource(value = {"4:3", "1:0"}, delimiter = ':')
    void roundCloseTest(int rounds, int leftRounds){
        RacingGameRounds racingGameRounds = new RacingGameRounds(rounds);
        racingGameRounds.roundClose();
        int leftover = racingGameRounds.getTries();
        assertEquals(leftRounds, leftover);

    }

    @DisplayName("isEnd 메소드 유효성 테스트")
    @ParameterizedTest
    @CsvSource(value = {"0:true", "1:false"}, delimiter = ':')
    void isEndTest(int rounds, boolean expectedValue){
        RacingGameRounds racingGameRounds = new RacingGameRounds(rounds);
        boolean isEnd = racingGameRounds.isEnd();
        assertEquals(expectedValue, isEnd);

    }
}
