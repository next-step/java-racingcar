package racinggame.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void 자동차를_생성하면_처음_거리는_0이다() {
        Car actual = new Car(new CarName("pobi"));
        Car expected = new Car(new CarName("pobi"), new Distance());

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 자동차는_움직인다() {
        Car actual = new Car(new CarName("pobi"));

        actual.move();

        Car expected = new Car(new CarName("pobi"), new Distance(1));

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 자동차가_이동한_거리를_표출_할_수_있다() {
        Car car = new Car(new CarName("pobi"));
        car.move();

        Distance actual = car.movingDistance();
        Distance expected = new Distance(1);

        assertThat(actual).isEqualTo(expected);
    }

}
