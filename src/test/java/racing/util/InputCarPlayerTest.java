package racing.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.Players;
import racing.domain.Player;
import racing.view.InputCarPlayer;

import static org.assertj.core.api.Assertions.assertThat;


class InputCarPlayerTest {

    @Test
    @DisplayName("Game Input 값을 ,(콤마)로 분리한다")
    public void split_input_data_seperator() throws Exception {
        //arrange
        String inputValue = "pobi,crong,honux";

        //act
        Players players = InputCarPlayer.createPlayers(inputValue);

        //assert
        assertThat(players.getPlayers()).containsExactly(
                new Player("pobi"),
                new Player("crong"),
                new Player("honux"));
    }

    @Test
    @DisplayName("경주 참가 플레이어 이름은 반드시 5자여야하는데 이를 초과할경우 빈 players값이 반환된다")
    public void must_be_five_length_below_player_name() throws Exception {
        //arrange
        String inputValue = "pobi,crong,honuxxxx";

        //act
        Players players = InputCarPlayer.createPlayers(inputValue);

        //assert
        assertThat(players.getPlayers()).isEmpty();
    }
}