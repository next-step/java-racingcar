package step4;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class RaceTest {

    private final Race race = new Race(2, List.of("test1", "test2"), new RandomStrategy());

    @Test
    public void 총_라운드_보다_현재_라운드가_작거나_같으면_경기가_진행_중이다() {
        assertTrue(race.isInRace());
    }
}
