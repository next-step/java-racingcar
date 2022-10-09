package racing.domain.car;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    void 자동차는_조건에_맞으면_움직일_수_있다() {
        Car car = new Car("name");
        car.move(() -> true);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 자동차는_조건에_안맞으면_움직이지_않는다() {
        Car car = new Car("name");
        car.move(() -> false);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 앞선_위치값을_가진_자동차가_선두_그룹이다() {
        Car leader = new Car("lead", 2);
        Car follower = new Car("loser", 1);
        assertThat(leader.leading(follower)).isEqualTo(leader);
    }
}
