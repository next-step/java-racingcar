import domain.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    @DisplayName("조건에_충족하면_move증가")
    void 조건에_충족하면_move증가() {
        Car car = new Car("red", 0);

        car.move(true);
        car.move(true);

        assertThat(car.getPosition()).isEqualTo(2);
    }

    @Test
    @DisplayName("조건에_충족하지_못하면_move증가X")
    void 조건에_충족하지_못하면_move증가X() {
        Car car = new Car("blue", 0);

        car.move(false);
        car.move(false);

        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("name이_동일하면_같은_객체인지_확인")
    void name이_동일하면_같은_객체인지_확인() {
        Car car1 = new Car("red", 5);
        Car car2 = new Car("red", 1);

        assertThat(car1.equals(car2)).isTrue();
    }
}
