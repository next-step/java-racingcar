package carRacing.race;

import carRacing.car.Cars;
import carRacing.common.RandomGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RacingGameTest {

    private RandomGenerator generator;
    private Cars cars;
    private RacingGameUI ui;
    private RacingGame racingGame;

    @BeforeEach
    public void setUp(){
        generator = mock(RandomGenerator.class);
        ui = mock(RacingGameUI.class);
        cars = Cars.of(new ArrayList<>());
        racingGame = RacingGame.of(generator, cars,ui);
    }

    @Test
    public void startRacing_ShouldRunningWithOutException(){
        when(generator.generate()).thenReturn(5);
        assertDoesNotThrow(()->
                racingGame.startRacing("Zelda, Link", 3));
        verify(ui, atLeastOnce()).printWinners(anyString());
    }

}