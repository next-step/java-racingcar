package racing;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void 자동차를_무작위로_이동_시킨다(){
        Car car = new Car(new RandomRule());
        car.move();
        assertThat(car.compare(car, new Car(new RandomRule()))).isIn(1, 0);
    }

    @Test
    void 자동차가_무조건_이동(){
        Car car = new Car(new NoRule());
        car.move();
        assertThat(car.compare(car, new Car(new NoRule()))).isEqualTo(1);
    }
}