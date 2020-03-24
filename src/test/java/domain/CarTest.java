package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private Car myCar;

    @BeforeEach
    public void setup() {
        myCar = new Car("myCar");
    }

    @Test
    public void moveTest() {
        // Given
        int location = myCar.getCurrentLocation();
        // When
        myCar.move();
        // Then
        assertThat(myCar.getCurrentLocation()).isNotEqualTo(location)
                .isEqualTo(location + 1);
    }


}
