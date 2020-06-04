package autoracing;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.Field;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RacingGameTest {
    private RacingRule rule;

    @BeforeAll
    public void init() {
        this.rule = new RandomRacingRule(10, 4);
    }

    @ParameterizedTest
    @CsvSource({"3,5", "2,7"})
    public void shouldCreateCars(int numberOfCars, int totalRounds) throws NoSuchFieldException, IllegalAccessException {
        RacingGame game = new RacingGame(numberOfCars, totalRounds, rule);

        Field participantsMember = RacingGame.class.getDeclaredField("participants");
        participantsMember.setAccessible(true);
        List<Car> participants = (List<Car>) participantsMember.get(game);
        assertThat(participants.size()).isEqualTo(numberOfCars);

        Field totalRoundsMember = RacingGame.class.getDeclaredField("totalRounds");
        totalRoundsMember.setAccessible(true);
        int savedRounds = (int) totalRoundsMember.get(game);
        assertThat(savedRounds).isEqualTo(totalRounds);
    }
}
