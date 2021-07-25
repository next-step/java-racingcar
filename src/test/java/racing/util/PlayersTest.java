package racing.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.CarNameException;
import racing.domain.Players;
import racing.domain.Player;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class PlayersTest {
    @Test
    @DisplayName("input 값중에 limit length를 넘기는 값이 있으면 CarNameException가 발생한다")
    public void must_be_return_false_limit_length_up_input_value() throws Exception {
        //arrange, act, assert
        assertThatExceptionOfType(CarNameException.class).isThrownBy(() -> {
            List<Player> players = Arrays.asList(
                    new Player("aaa"),
                    new Player("eeeeeeee"));

            new Players(players);
        });
    }

    @Test
    @DisplayName("input 값중에 limit length를 넘기는 값이 없으면 CarNameException가가 발생하지 않는다")
    public void must_be_return_true_limit_length_below_input_value() throws Exception {
        //arrange, act, assert
        assertDoesNotThrow(() -> {
            List<Player> players = Arrays.asList(
                    new Player("aaa"),
                    new Player("bbbb"),
                    new Player("ccccc"));

            new Players(players);
        });
    }

    @Test
    @DisplayName("Player가 없으면 empty메소드 호출시 true를 반환한다")
    public void must_be_return_true_players_empty() throws Exception {
        //arrange
        Players players = Players.empty();

        //act, assert
        assertTrue(players.isEmpty());
    }
}