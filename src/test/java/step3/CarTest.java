package step3;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import step3.domain.Car;
import step3.domain.Name;
import step3.domain.Position;

public class CarTest {

    @Test
    void 전진하지않는테스트() {
        Car car = new Car(new Name("a"), new Position(0));
        Position position = car.advanceCar(1);
        assertThat(position).isEqualTo(new Position(0));
    }

    @Test
    void 전진하는테스트() {
        Car car = new Car(new Name("a"), new Position(0));
        Position position = car.advanceCar(4);
        assertThat(position).isEqualTo(new Position(1));
    }

    @Test
     void 현재위치확인테스트() {
        Car car = new Car(new Name("a"), new Position(0));
        assertThat(car.currentPosition()).isEqualTo(new Position(0));
    }

    @Test
    void 최대값_일치() {
        Car car = new Car(new Name("abc"), new Position(3));
        assertThat(car.isMaxPosition(new Position(3))).isTrue();
        assertThat(car.isMaxPosition(new Position(2))).isFalse();
    }

    @Test
    void 최댓값구하기() {
        Car car = new Car(new Name("abc"), new Position(3));
        assertThat(car.maxPosition(new Position(4))).isEqualTo(new Position(4));
        assertThat(car.maxPosition(new Position(2))).isEqualTo(new Position(3));
    }
}
