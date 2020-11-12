package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MoveCheckorTest {


    @Test
    @DisplayName("기준치에 따른 boolean 리턴 테스트")
    public void randomNumTest(){
        MoveCheckor moveCheckor = new MoveCheckor();

        if(moveCheckor.getRandomNum() >= moveCheckor.getBaseLineNum()){
            assertThat(moveCheckor.checkOverBaseLine()).isTrue();
        }
    }

    @Test
    @DisplayName("이동에 따른 기록 저장 테스트")
    public void recordDistanceTest(){
        MoveCheckor moveCheckor = new MoveCheckor();
        Car testCar = new Car("pobi");

        moveCheckor.moveAndStop(testCar);

        assertThat(testCar.getRecordList().size()).isEqualTo(1);


    }
}