package step3;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import step3.domain.Car;
import step3.domain.Name;
import step3.domain.Position;

public class CarTest {

    @Test
    public void 전진하지않는테스트() {
        Car car = new Car(new Name("a"), new Position(0));
        Position position = car.advanceCar(1);
        assertThat(position).isEqualTo(new Position(0));
    }

    @Test
    public void 전진하는테스트() {
        Car car = new Car(new Name("a"), new Position(0));
        Position position = car.advanceCar(4);
        assertThat(position).isEqualTo(new Position(1));
    }

    @Test
    public void 현재위치확인테스트() {
        Car car = new Car(new Name("a"), new Position(0));
        assertThat(car.currentPosition()).isEqualTo(new Position(0));
    }
}
