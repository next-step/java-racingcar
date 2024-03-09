package step3;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RacingCarTest {

    Car car;

    @BeforeEach
    void beforeEach() {
        AlwaysMoveStrategy alwaysMoveStrategy = new AlwaysMoveStrategy();
        car = new Car(alwaysMoveStrategy);
    }

    @Test
    public void 자동차_객체를_생성하고_현재_위치를_조회하면_0이_나온다() {
        assertThat(car.getCurrentLocation()).isEqualTo(0);
    }

    @Test
    public void random값이_4이상이면_현재_위치에서_한칸_전진한다() {
        car.moveForwardOnChance();
        assertThat(car.getCurrentLocation()).isEqualTo(1);
    }

    @Test
    public void 입력받은_수_만큼_자동차가_생성된다() {
        AlwaysMoveStrategy alwaysMoveStrategy = new AlwaysMoveStrategy();
        CarRacing carRacing = new CarRacing(3, alwaysMoveStrategy);
        assertThat(carRacing.getCars().size()).isEqualTo(3);
    }


}
