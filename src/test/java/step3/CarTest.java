package step3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

class CarTest {

    @Test
    void 주어진_숫자가_4이상이면_자동차는_전진한다() {
        int randomNumbers = 4;
        Car car = new Car(new CarEngine());
        car.move(randomNumbers);

        assertThat(car.getMovedCount()).isEqualTo(1);
    }

    @Test
    void 주어진_숫자가_3이하이면_자동차는_할_수_없다() {
        int randomNumbers = 3;
        Car car = new Car(new CarEngine());
        car.move(randomNumbers);

        assertThat(car.getMovedCount()).isEqualTo(0);
    }
}
