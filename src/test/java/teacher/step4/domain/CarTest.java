package teacher.step4.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    void 최대이동거리_구하기() {
        Car car = new Car("pobi", 3);
        assertThat(car.maxPosition(2)).isEqualTo(3);
        assertThat(car.maxPosition(4)).isEqualTo(4);
    }

    @Test
    void 최대이동거리_유무() {
        int maxPosition = 3;
        assertThat(new Car("pobi", 3).isWinner(maxPosition)).isTrue(); // car.isMaxPosition(maxPosition); getter 의 대체
        assertThat(new Car("pobi", 2).isWinner(maxPosition)).isFalse();
    }

    @Test
    public void 이동() {
        Car car = new Car("pobi");
        car.move(3);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 정지() {
        Car car = new Car("pobi");
        car.move(4);
        assertThat(car.getPosition()).isEqualTo(0);
    }
}