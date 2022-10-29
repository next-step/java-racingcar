package carracing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    @DisplayName("Constructor Test")
    public void constructorTest() {
        Car testCar = new Car(1,"name1");
        assertThat(testCar).usingRecursiveComparison().isEqualTo(new Car(1, "name1"));
    }

    @Test
    @DisplayName("Move Test")
    public void moveTest() {
        Car testCar = new Car(1,"name1");
        NumberGenerator numberGenerator = new MovableNumberGenerator();
        testCar.move(numberGenerator);
        assertThat(testCar).extracting("position").isEqualTo(1);
    }
}
