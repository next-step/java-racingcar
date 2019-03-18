package service;

import domain.RacingGameInfo;
import domain.RacingGameResult;
import org.junit.Test;
import util.StringParser;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameServiceTest {
    private final RacingGameService racingGameService = new RacingGameService();

    @Test
    public void create_racing_game_info() {
        Integer gameCount = 3;
        List<String> carNames = StringParser.split( "adele, maroon, justin");

        RacingGameInfo racingGameInfo = racingGameService.initGameInfo(gameCount, carNames);
        assertThat(racingGameInfo.getGameCount()).isEqualTo(3);
        assertThat(racingGameInfo.getCars()).hasSize(3);
    }

    @Test
    public void return_result_after_game() {
        RacingGameInfo racingGameInfo = racingGameService.initGameInfo(
            3, StringParser.split("adele, maroon, justin"));

        RacingGameResult racingGameResult = racingGameService.playGames(racingGameInfo);
        assertThat(racingGameResult.getRoundResults()).hasSize(3);
        assertThat(racingGameResult.getWinner().size()).isGreaterThan(0);
    }
}
