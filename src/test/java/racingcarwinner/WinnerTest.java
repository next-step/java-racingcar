package racingcarwinner;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class WinnerTest {

    @Test
    @DisplayName("이름 가져오기 테스트")
    public void getName(){
        assertEquals(new Winner("베니").getName().getString(),"베니");
    }

}
