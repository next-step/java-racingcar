package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RaceTest {
    Race race;
    @BeforeEach
    void setUp() {
        race = new Race(new RaceInfo(new CarNumber(3), new RaceNumber(5)));
    }

    @Test
    void calculate() {
        RaceResult raceResult = race.calculate();
    }
}
