package carracing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    @DisplayName("Move Test")
    public void moveTest() {
        Car testCar = new Car(new Name("name1"));
        NumberGenerator numberGenerator = new MovableNumberGenerator();

        testCar.move(numberGenerator);
        assertThat(testCar).extracting("position").isEqualTo(1);
    }

    @Test
    public void samePositionTest(){
        Car testCar = new Car(new Name("name1"),3);

        assertThat(testCar.samePosition(3)).isTrue();
    }
}
