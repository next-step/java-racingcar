package race;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CarTest {
    @Test
    void create_자동차를_생성한다() {
        Car car = Car.create();

        assertThat(car).isInstanceOf(Car.class);
        assertThat(car.getCurrentStep()).isEqualTo(0);
    }

    @Test
    void getCurrentStep_자동차가_현재_위치한_칸을_반환한다() {
        Car car = Car.create();

        assertThat(car.getCurrentStep()).isEqualTo(0);
    }

    @Test
    void move_자동차가_이동한다() {
        Car car = Car.create();
        int previousStep = car.getCurrentStep();
        car.move();

        assertThat(car.getCurrentStep()).isEqualTo(previousStep + 1);
    }
}
