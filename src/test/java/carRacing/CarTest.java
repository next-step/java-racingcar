package carRacing;

import carRacing.model.Car;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("4이상의 출력으로 움직였을때")
    public void move() {
        Car car = new Car("test");
        int position = car.move(4);
        assertThat(position).isEqualTo(1);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("4보다 작은 출력으로 움직였을때")
    public void stop() {
        Car car = new Car("test");
        int position = car.move(3);
        assertThat(position).isEqualTo(0);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("이름을 빈값으로 생성시 예외처리")
    public void emptyNameException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Car("");
        });
    }

    @Test
    @DisplayName("이름을 null 예외처리")
    public void nullNameException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Car(null);
        });
    }
}