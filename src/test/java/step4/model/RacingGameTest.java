package step4.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("RacingGame 자체에 대한 Test")
public class RacingGameTest {
    RacingGame game;

    @ParameterizedTest
    @CsvSource(value = {"0,John", "1,Jay", "2,Kim"})
    void create_RacingGame_with_participants(int position, String expectedName) {
        List<String> participants = new ArrayList<>(Arrays.asList("John", "Jay", "Kim"));
        game = new RacingGame(participants);
        assertThat(game.getPlayerList().get(position).getCarName()).isEqualTo(expectedName);
    }


}
