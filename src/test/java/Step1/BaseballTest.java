package Step1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

// params: 'computer', 'user', ball, strike
public class BaseballTest {
    @ParameterizedTest
    @CsvSource({
            "'123', '456', 0, 0",
            "'713', '123', 1, 1",
            "'713', '145', 1, 0",
            "'713', '671', 2, 0",
            "'713', '216', 0, 1",
            "'713', '713', 0, 3",
            "'874', '362', 0, 0",
            "'198', '421', 1, 0",
            "'432', '231', 1, 1",
            "'432', '431', 0, 2",
            "'432', '234', 2, 1",
    })
    void match(String computer, String user, int exp_ball, int exp_strike){
        Baseball game = new Baseball();

        Result result = game.play(computer, user);

        assertThat(result.ball).isEqualTo(exp_ball);
        assertThat(result.strike).isEqualTo(exp_strike);
    }
}
