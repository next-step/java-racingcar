package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class RaceResultTest {
    RaceResult raceResult;

    @BeforeEach
    void setUp() {
        raceResult = new RaceResult();
        raceResult.add(new GameResult(new CarNumber(3)));
    }

    @Test
    void getGames() {
        ArrayList<GameResult> gameResults = new ArrayList<>(Collections.singletonList(
            new GameResult(new ArrayList<>(Arrays.asList(new Car(1), new Car(1), new Car(1))))
        ));
        assertEquals(new RaceResult(gameResults), raceResult);
    }

    @Test
    void add() {
        raceResult.add(new GameResult(new CarNumber(3)));

        ArrayList<GameResult> gameResults = new ArrayList<>(Arrays.asList(
            new GameResult(new ArrayList<>(Arrays.asList(new Car(1), new Car(1), new Car(1)))),
            new GameResult(new ArrayList<>(Arrays.asList(new Car(1), new Car(1), new Car(1))))
        ));
        assertEquals(new RaceResult(gameResults), raceResult);
    }
}
