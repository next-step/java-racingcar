package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class RaceResultTest {
    final static int DEFAULT_NUMBER_OF_CARS_VALUE = 3;
    final static int INITIAL_CAR_POSITION = 1;
    RaceResult defaultRaceResult;

    @BeforeEach
    void setUp() {
        defaultRaceResult = new RaceResult();
        defaultRaceResult.add(GameResult.createInitialGameResult(new NumberOfCars(DEFAULT_NUMBER_OF_CARS_VALUE)));
    }

    @Test
    void getGames() {
        ArrayList<GameResult> gameResults = new ArrayList<>(Collections.singletonList(
            GameResult.create(new ArrayList<>(Arrays.asList(new Car(INITIAL_CAR_POSITION), new Car(INITIAL_CAR_POSITION), new Car(INITIAL_CAR_POSITION))))
        ));
        assertEquals(new RaceResult(gameResults), defaultRaceResult);
    }

    @Test
    void add() {
        defaultRaceResult.add(GameResult.createInitialGameResult(new NumberOfCars(DEFAULT_NUMBER_OF_CARS_VALUE)));

        ArrayList<GameResult> gameResults = new ArrayList<>(Arrays.asList(
            GameResult.create(new ArrayList<>(Arrays.asList(new Car(INITIAL_CAR_POSITION), new Car(INITIAL_CAR_POSITION), new Car(INITIAL_CAR_POSITION)))),
            GameResult.create(new ArrayList<>(Arrays.asList(new Car(INITIAL_CAR_POSITION), new Car(INITIAL_CAR_POSITION), new Car(INITIAL_CAR_POSITION))))
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
        assertEquals("[[{location : 1}, {location : 1}, {location : 1}]]", defaultRaceResult.toString());
    }
}
