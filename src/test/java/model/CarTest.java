package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    private Car car;

    @Test
    public void isMaxPosition() {
        Car car = new Car(2, "LEE");
        Position maxPosition = new Position(3);

        assertThat(car.isMaxPosition(maxPosition)).isFalse();
    }
}
