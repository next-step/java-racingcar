package step5.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @Test
    void create_RaceGame_Initialize() {
        String[] carsName = new String[]{"Jamie", "Goal"};
        RacingGame raceGame = new RacingGame(Arrays.asList(carsName));
        assertThat(raceGame).isNotNull();
    }

    @Test
    void check_Winner_Member_After_GamePlay() {
        List<Car> cars = new ArrayList<>(Arrays.asList(new Car("John"), new Car("Kim")));
        Participants partc = new Participants(cars);
        RacingGame raceGame = new RacingGame(partc.getMemberOfParticipants());
        raceGame.playGame(() -> true);
        raceGame.playGame(() -> true);

        assertThat(raceGame.getWinnerPlayers()).contains("John", "Kim");
    }
}