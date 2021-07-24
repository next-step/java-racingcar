package racing.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.Players;
import racing.domain.Player;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PlayersTest {
    @Test
    @DisplayName("input 값중에 limit length를 넘기는 값이 있으면 false를 반환한다")
    public void must_be_return_false_limit_length_up_input_value() throws Exception {
        //arrange
        List<Player> players = Arrays.asList(
                new Player("aaa"),
                new Player("eeeeeeee"));
        Players carPlayers = new Players(players);

        //act, assert
        assertFalse(carPlayers.isCorrectNames());
    }

    @Test
    @DisplayName("input 값중에 limit length를 넘기는 값이 없으면 true를 반환한다")
    public void must_be_return_true_limit_length_below_input_value() throws Exception {
        //arrange
        List<Player> players = Arrays.asList(
                new Player("aaa"),
                new Player("bbbb"),
                new Player("ccccc"));
        Players carPlayers = new Players(players);

        //act, assert
        assertTrue(carPlayers.isCorrectNames());
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