package study.step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarTest {
    Car car;
    @BeforeEach

    void setCar() {
        car = new Car();
    }

    @Test
    public void 자동차테스트_이동 () throws Exception {
        //given
        Boolean move;

        for (int i = 0; i < 10; i++) {
            if (i >= 4) {
                //when
                move = car.isMove(i);
                //then
                assertThat(move).isEqualTo(true);
            }
        }
    }

    @Test
    public void 자동차이동테스트_멈춤 () throws Exception {
        //given
        Boolean move;

        for (int i = 0; i < 10; i++) {
            if (i < 4) {
                //when
                move = car.isMove(i);
                //then
                assertThat(move).isEqualTo(false);
            }
        }

    }

}