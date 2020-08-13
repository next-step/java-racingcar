package step3;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class CarTest {

    private Car car = new Car("Test");

    @Test
    void constructorNameLengthException() {
        assertThatThrownBy(() -> new Car("zimbabuwae")).isInstanceOf(NameLengthException.class);
    }

    @Test
    void advance() {
        int preMiles = car.getMiles();
        car.advance(() -> true);

        assertThat(car.getMiles()).isEqualTo(preMiles + 1);
    }
}
