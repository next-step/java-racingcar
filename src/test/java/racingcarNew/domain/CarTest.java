package racingcarNew.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private static final int DEFAULT_CAR_POSITION = 0;

    @Test
    void 자동차가_이동하는지_확인() {
        Car car = new Car("pobi", DEFAULT_CAR_POSITION);
        car.move(5);
        assertThat(1).isEqualTo(car.getPosition());
    }

    @Test
    void 자동차가_이동하지_않는지_확인() {
        Car car = new Car("pobi", DEFAULT_CAR_POSITION);
        car.move(2);
        assertThat(0).isEqualTo(car.getPosition());
    }

    @Test
    void 자동차경주_우승자가_나오는지_확인(){
        Car car = new Car("pobi", 3);
        car.move(3);
        assertThat(car.isWinner(3)).isTrue();
    }

}