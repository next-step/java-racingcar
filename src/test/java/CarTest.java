import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    void test() {
        Car car = new Car();
        String a = "pobi,woni,jun";

        assertThat(Car.result().matches(a));
    }
}
