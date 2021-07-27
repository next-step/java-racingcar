package racing;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import step2.Calculator;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RacingTest {


    public static Racing racing = new Racing();

    @Test
    public void isGameOverTest() {

        Integer tryNum = 5;

        Integer[] carList1 = new Integer[3];
        Integer[] carList2 = new Integer[3];
        carList1[0] = 1;
        carList1[1] = 2;
        carList1[2] = 3;

        carList2[0] = 0;
        carList2[1] = 5;
        carList2[2] = 0;

        Boolean result1 = racing.isGameOver(carList1, tryNum);
        Boolean result2 = racing.isGameOver(carList2, tryNum);

        assertEquals(result1,true);
        assertEquals(result2,false);

    }

    @Test
    public void gameInitiateTest() {
        Integer carNum = 3;

        Integer[] result = racing.gameInitiate(carNum);

        for(int idx = 0; idx < carNum; idx++) {
            assertEquals(0,result[idx]);
        }

    }

    @Test
    public void isMoveTest() {

        Boolean result1 = racing.isMove(1);
        Boolean result2 = racing.isMove(5);

        assertEquals(result1,false);
        assertEquals(result2,true);
    }

    @Test
    public void makeRanNumTest() {

        Integer result1 = racing.makeRanNum();

        String regExp = "^[0-9]+$";

        assertEquals(result1.toString().matches(regExp), true);
    }

    @Test
    public void setCarMoveTest() {

        Integer[] carList1 = new Integer[3];
        carList1[0] = 1;
        carList1[1] = 2;
        carList1[2] = 3;

        racing.setCarMove(carList1);

        //??
    }

}
