package racingcarrefectoring;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import racingcarrefectoring.model.Position;

import static org.junit.Assert.assertEquals;

public class PositionTest {

    @Test
    @DisplayName("포지션을 제대로 만들고 있는가")
    public void setPosition(){
        Position position = new Position(0);
        assertEquals(position.getValue(),0);

        Position position2 = new Position(1);
        assertEquals(position2.getValue(),1);
    }

    @Test
    @DisplayName("증가된 값을 가진 객체를 정상적으로 만들고 있는가")
    public void increasePosition(){
        Position position = new Position(0);
        assertEquals(position.getValue(),0);

        position = position.increase();
        assertEquals(position.getValue(),1);
    }
}
