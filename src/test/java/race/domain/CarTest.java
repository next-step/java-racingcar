package race.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @Test
    void 자동차_이름_길이_성공() {
        String name = "abcde";
        assertThat(new Car(name,0).checkNameLength(name)).isTrue();
    }

    @Test
    void 자동차_이름_길이_실패() {
        String name = "abcdef";
        assertThatThrownBy(() -> new Car(name, 0)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 위치_받아오기() {
        int position = 0;
        assertThat(new Car(position).getPosition()).isEqualTo(position);
    }

    @Test
    void 전진() {
        Car car = new Car(0);
        assertThat(car.canForward(4)).isTrue();
    }

    @Test
    void 정지() {
        Car car = new Car(0);
        assertThat(car.canForward(3)).isFalse();
    }

    @Test
    void 이동() {
        Car car = new Car(0);
        car.move();
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 최댓값() {
        assertThat(Math.max(1,2)).isEqualTo(2);
    }

    @Test
    void 같은_위치() {
        Car car = new Car("",1);
        int position = 1;
        assertThat(car.isSamePosition(position)).isTrue();
    }
}
