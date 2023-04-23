package racing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author : 0giri
 * @since : 2023/04/15
 */
public class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        this.car = new Car();
    }

    @Test
    void 복사생성자로_생성된_복제본_변경시_원본_유지() {
        //given
        car.move(10);
        Car copy = new Car(car);

        //when
        copy.move(5);

        //then
        assertThat(car.location()).isEqualTo(10);
        assertThat(copy.location()).isEqualTo(15);
    }

    @Test
    void 자동차_거리_4이상_전진() {
        //when
        car.move(5);

        //then
        assertThat(car.location()).isEqualTo(5);
    }

    @Test
    void 자동차_거리_4미만_멈춤() {
        //given
        car.move(5);
        assertThat(car.location()).isEqualTo(5);

        //when
        car.move(2);

        //then
        assertThat(car.location()).isEqualTo(5);
    }

    @Test
    void 자동차_여러번_이동시_위치_누적() {
        //when
        car.move(5);
        car.move(2);
        car.move(8);

        //then
        assertThat(car.location()).isEqualTo(13);
    }

    @Test
    void 자동차_현재위치_반환() {
        //given
        assertThat(car.location()).isEqualTo(0);

        //when
        car.move(7);

        //then
        assertThat(car.location()).isEqualTo(7);
    }
}
