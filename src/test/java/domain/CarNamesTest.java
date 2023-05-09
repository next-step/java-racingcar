package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarNamesTest {
    List<CarName> carNames;

    @BeforeEach
    void setUp() {
        carNames = Arrays.asList(CarName.create("hello"), CarName.create("hi"));
    }

    @Test
    void toNumberOfCars() {
        assertEquals(new NumberOfCars(2), CarNames.toNumberOfCars(carNames));
    }
}
