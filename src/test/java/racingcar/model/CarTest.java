package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void 자동차는_전진하면_위치가_증가한다() {
        Car car = new Car("leah", 2);
        car.moveForward();
        assertThat(car.getPosition()).isEqualTo(3);
    }

    @Test
    void 가장_멀리간_자동차가_5만큼_갔을때_일치하는_자동차_찾기() {
        Car car = new Car("leah", 5);
        int maxPosition = 5;
        assertThat(car.isSamePosition(maxPosition)).isEqualTo(true);
    }

    @Test
    void 현재까지_찾은_맥스_포지션과_비교하기() {
        Car carLeah = new Car("Leah", 3);
        int result = carLeah.compareMaxPosition(2);
        assertThat(result).isEqualTo(3);
    }
}
