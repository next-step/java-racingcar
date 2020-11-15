package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MoveCheckerTest {


    @Test
    @DisplayName("기준치에 따른 boolean 리턴 테스트")
    public void randomNumTest(){
        MoveChecker moveChecker = new MoveChecker();

        if(moveChecker.getRandomNum() >= moveChecker.getBaseLineNum()){
            assertThat(moveChecker.checkOverBaseLine()).isTrue();
        }
    }

    @Test
    @DisplayName("이동에 따른 기록 저장 테스트")
    public void recordDistanceTest(){
        MoveChecker moveChecker = new MoveChecker();
        Car testCar = new Car("pobi");

        moveChecker.moveAndStop(testCar);

        assertThat(testCar.getRecordList().size()).isEqualTo(1);


    }
}