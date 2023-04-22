package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RaceResultTestRefactoring {
    final static int DEFAULT_MOVE_VALUE = 2;
    final static int DEFAULT_NUMBER_OF_CARS_VALUE = 3;
    final static int INITIAL_CAR_POSITION = 1;

    CarState defaultCarState;
    CarDisplacement defaultCarDisplacement;
    Car defaultCar;
    RaceResult defaultRaceResult;

    @BeforeEach
    void setUp() {
        defaultCarState = DefaultCarState.create(INITIAL_CAR_POSITION);
        defaultCarDisplacement = DefaultCarDisplacement.create(DEFAULT_MOVE_VALUE);
        defaultCar = Car.createCar(defaultCarState, defaultCarDisplacement);

        defaultRaceResult = new RaceResult();
        defaultRaceResult.add(GameResult.createInitialGameResult(new NumberOfCars(DEFAULT_NUMBER_OF_CARS_VALUE)));
    }

    @Test
    void getGames() {
        ArrayList<GameResult> gameResults = new ArrayList<>(Collections.singletonList(
            GameResult.create(new ArrayList<>(Arrays.asList(defaultCar, defaultCar, defaultCar)))
        ));
        assertEquals(new RaceResult(gameResults), defaultRaceResult);
    }

    @Test
    void add() {
        defaultRaceResult.add(GameResult.createInitialGameResult(new NumberOfCars(DEFAULT_NUMBER_OF_CARS_VALUE)));

        ArrayList<GameResult> gameResults = new ArrayList<>(Arrays.asList(
            GameResult.create(new ArrayList<>(Arrays.asList(defaultCar, defaultCar, defaultCar))),
            GameResult.create(new ArrayList<>(Arrays.asList(defaultCar, defaultCar, defaultCar)))
        ));
        assertEquals(new RaceResult(gameResults), defaultRaceResult);
    }

    @Test
    void testEquals() {
        RaceResult raceResult = new RaceResult();
        raceResult.add(GameResult.createInitialGameResult(new NumberOfCars(DEFAULT_NUMBER_OF_CARS_VALUE)));

        assertEquals(raceResult, defaultRaceResult);
    }

    @Test
    void testToString() {
        assertEquals("[[{position : 1}, {position : 1}, {position : 1}]]", defaultRaceResult.toString());
    }
}
