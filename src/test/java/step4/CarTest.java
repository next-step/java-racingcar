package step4;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @Test
    void inputCarExceptionTest() {
        assertThatThrownBy(() -> {
            new Car(new String[]{"test1111", "test1"}, 5);
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    void inputCarTest() {
        Car car = new Car(new String[]{"test1", "test2"}, 5);
        
        assertThat(car.getTimes()).isEqualTo(5);
        assertThat(car.getNames().get(0)).isEqualTo("test1");
    }
}
