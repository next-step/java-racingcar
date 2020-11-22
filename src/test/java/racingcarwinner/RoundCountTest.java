package racingcarwinner;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RoundCountTest {

    @Test
    @DisplayName("경기 수 객체 생성과 값 반환이 잘 되는가")
    public void getValueTest(){
        RoundCount roundCount = new RoundCount(3);

        assertEquals(roundCount.getValue(),3);

    }

}
