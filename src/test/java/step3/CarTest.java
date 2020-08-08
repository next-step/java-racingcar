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
        assertThat(challenger.showDistance()).isEqualTo(1);
    }

    @Test
    void increse_Car_Distance_with_Method() {
        challenger = new Car();
        challenger.increaseDistance();
        assertThat(challenger.showDistance()).isEqualTo(2);
    }

    @Test
    void increate_Car_Distance_with_Randomize() {
        challenger = new Car();
        for (int i = 0; i <= 10; i++) {
            challenger.increaseDistanceWithRandom();
        }
        assertThat(challenger.showDistance()).isGreaterThan(2);
    }
}
