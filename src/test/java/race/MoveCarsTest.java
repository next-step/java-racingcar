package race;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@ExtendWith(MockitoExtension.class)
class MoveCarsTest {
    @Mock
    private JudgeCarMovement judgeCarMovement;

    @InjectMocks
    @Spy
    private MoveCars dut;

    @AfterEach
    void tearDown() {
        verifyNoMoreInteractions(judgeCarMovement);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 7, 9})
    void moveCars(int numberOfCars) {
        Collection<Car> cars = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            cars.add(new Car());
        }

        doNothing().when(dut).moveCar(any());

        dut.moveCars(cars);

        cars.forEach((car -> verify(dut, times(1)).moveCar(car)));
    }

    @Test
    void moveCar_move() {
        Car car = new Car();

        when(judgeCarMovement.judge()).thenReturn(JudgeCarMovement.Judge.MOVE);

        dut.moveCar(car);

        assertThat(car.location()).isEqualTo(1);
    }

    @Test
    void moveCar_stay() {
        Car car = new Car();

        when(judgeCarMovement.judge()).thenReturn(JudgeCarMovement.Judge.STAY);

        dut.moveCar(car);

        assertThat(car.location()).isEqualTo(0);
    }
}
