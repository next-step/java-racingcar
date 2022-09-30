package step3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RaceTest {

    private final Race race = new Race(2, 3);

    @Test
    public void 총_라운드_보다_현재_라운드가_작거나_같으면_경기가_진행_중이다() {
        assertTrue(race.isInRace());
    }
}
