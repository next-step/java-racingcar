package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.model.Car;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Step3 - 자동차 Object에 대한 Test")
public class CarTest {
    private Car challenger;

    @Test
    void new_Car_object_creation() {
        challenger = new Car();
        assertThat(challenger.showDistance()).isEqualTo(0);
    }

    @Test
    void increse_Car_Distance_with_Method() {
        challenger = new Car();
        challenger.increseDistance();
        assertThat(challenger.showDistance()).isEqualTo(1);
    }
}
