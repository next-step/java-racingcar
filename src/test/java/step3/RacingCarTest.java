package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    @Test
    @DisplayName("자동차가 이동하면 상태값에 하이픈이 추가된다")
    public void 자동차가_이동하면_상태값에_하이픈이_추가된다() {
        //given
        //when
        RacingCar car = RacingCar.create().move();
        //then
        assertThat(car.printStatus()).isEqualTo("--");
    }

    @Test
    @DisplayName("자동차가 멈추면 상태값은 변하지 않는다")
    public void 자동차가_멈추면_상태값은_변하지_않는다() {
        //given

        //when
        RacingCar car = RacingCar.create().stop();
        //then
        assertThat(car.printStatus()).isEqualTo("-");
    }

}
