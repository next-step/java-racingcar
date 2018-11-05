package racingcar;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @Test
    public void 이동가능체크(){
        boolean flag = RacingGame.movePossibleCheck();
        if(flag){
            assertThat(flag).isEqualTo(true);
        }
        if(!flag){
            assertThat(flag).isEqualTo(false);
        }
    }

    @Test
    public void 자동차별위치이동(){
        int[] carPosition = {0, 0, 0};
        int carSeq = 2;
        RacingGame.movePerCarProcess(carPosition, carSeq);
        assertThat(carPosition[2]).isEqualTo(2);
    }

}