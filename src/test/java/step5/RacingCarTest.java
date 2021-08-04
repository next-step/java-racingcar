package step5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    @Test
    @DisplayName("자동차가 RandomMovable전략을 가지면 이동하거나 이동하지 않는다")
    public void 자동차가_RandomMovable전략을_가지면_이동하거나_이동하지_않는다() {
        //given
        RacingCar car = RacingCar.create("pobi");
        //when
        car.move(new RandomMovable());
        //then
        assertThat(car.getStatus()).isBetween(1, 2);
    }

    @Test
    public void 자동차는_Movable이_true를_반환할_때_이동할_수_있다(){
        //given
        RacingCar car = RacingCar.create("pobi");
        car = car.move(() -> true);
        //when
        assertThat(car).isEqualTo(RacingCar.create("pobi", 2));
        //then
    }
}
