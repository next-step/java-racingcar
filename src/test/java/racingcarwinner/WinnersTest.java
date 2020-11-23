package racingcarwinner;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class WinnersTest {

    @Test
    @DisplayName("우승자 객체 제대로 생성하는가")
    public void create(){

        Winners winners = new Winners();
        winners.addWinner("베니");

        assertTrue(winners.getWinner(0).equals(new Winner("베니")));
    }

    @Test
    @DisplayName("우승자 명수를 제대로 가져오는가")
    public void getCount(){
        Winners winners = new Winners();
        winners.addWinner("베니");
        winners.addWinner("코난");

        assertEquals(winners.getCount(),2);
    }



}
