package study.step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarTest {
    private Car car;

    @BeforeEach
    void setCar() {
        car = new Car(5);
    }

    @Test
    public void 자동차테스트_이동() {
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
    public void 자동차이동테스트_멈춤() {
        //given
        Boolean move;

        for (int i = 0; i < 4; i++) {
            if (i < 4) {
                //when
                move = car.isMove(i);
                //then
                assertThat(move).isEqualTo(false);
            }
        }
    }

    @Test
    public void 자동차_마지막바퀴_테스트() {
        //given
        for (int i = 0; i < 5; i++) {
            car.move();
        }
        assertThat(car.isFinish()).isEqualTo(true);
    }

}