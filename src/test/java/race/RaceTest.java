package race;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@ExtendWith(MockitoExtension.class)
class RaceTest {
    private Race dut;

    private List<Car> cars;

    @Mock
    private JudgeCarMovement judgeCarMovement;

    @Mock
    private RenderCarLocation renderCarLocation;

    @BeforeEach
    void setUp() {
        int numberOfCars = (new Random()).nextInt(100) + 1;
        cars = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            cars.add(mock(Car.class));
        }

        dut = spy(new Race(cars, judgeCarMovement, renderCarLocation));
    }

    @AfterEach
    void tearDown() {
        verifyNoMoreInteractions(judgeCarMovement, renderCarLocation);
        cars.forEach(Mockito::verifyNoMoreInteractions);
    }

    @Test
    void race() {
        int numberOfMovement = (new Random()).nextInt(10) + 1;

        doNothing().when(dut).moveCars();
        doNothing().when(dut).renderRacingSnapshot();

        dut.race(numberOfMovement);

        verify(dut, times(numberOfMovement)).moveCars();
        verify(dut, times(numberOfMovement)).renderRacingSnapshot();
    }

    @Test
    void moveCars() {
        doNothing().when(dut).moveCar(any());

        dut.moveCars();

        cars.forEach((car -> {
            verify(dut, times(1)).moveCar(car);
        }));
    }

    @Test
    void moveCar_move() {
        when(judgeCarMovement.judge()).thenReturn(JudgeCarMovement.Judge.MOVE);

        dut.moveCar(cars.get(0));

        verify(cars.get(0), times(1)).move();
    }

    @Test
    void moveCar_stay() {
        when(judgeCarMovement.judge()).thenReturn(JudgeCarMovement.Judge.STAY);

        dut.moveCar(cars.get(0));

        verify(cars.get(0), never()).move();
    }

    @Test
    void renderRacingSnapshot() {
        dut.renderRacingSnapshot();
        verify(renderCarLocation, times(1)).render(cars);
    }
}