package race;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RaceTest {
    private Race dut;

    private List<Car> cars;

    @Mock
    private JudgeCarMovement judgeCarMovement;

    @BeforeEach
    void setUp() {
        int numberOfCars = (new Random()).nextInt(100) + 1;
        cars = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            cars.add(new Car());
        }

        dut = new Race(cars, judgeCarMovement);
    }

    @AfterEach
    void tearDown() {
        verifyNoMoreInteractions(judgeCarMovement);
    }

    @Test
    void moveCar() {
        Boolean[] movement = new Boolean[cars.size()];
        for (int i = 0; i < cars.size(); i++) {
            movement[i] = i % 2 == 0;
        }
        when(judgeCarMovement.judge()).thenReturn(movement[0], Arrays.copyOfRange(movement, 1, movement.length));

        dut.moveCars();

        for (int i = 0; i < cars.size(); i++) {
            int expected = movement[i] ? 1 : 0;
            assertThat(cars.get(i).location()).isEqualTo(expected);
        }
    }

}