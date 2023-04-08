import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarPotisionTest {

    @Test
    @DisplayName("CarPosition_생성")
    public void Car_움직임_생성(){
        //given
        CarPosition carPosition = new CarPosition(3);
        //when

        //then
        assertThat(carPosition.getPositionValue()).isEqualTo(3);
    }

    @Test
    @DisplayName("CarPosition_Exception")
    public void CarPosition_Exception(){
        //given
        assertThatThrownBy(()->{
            new CarPosition(-1);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("차 움직임은 음수일 수 없습니다.");
        //when

        //then
    }

    @Test
    @DisplayName("CarPosition_move")
    public void CarPosition_move(){
        //given
        CarPosition carPosition = new CarPosition(3);
        CarPosition movedCarPosition = carPosition.move();
        assertThat(movedCarPosition.getPositionValue()).isEqualTo(4);
        //when

        //then
    }
}
