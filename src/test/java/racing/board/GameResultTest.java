package racing.board;

import org.junit.*;
import racing.model.NamedRacingCar;
import racing.model.RacingCar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;


public class GameResultTest {

    @Test
    public void test_최대값_위치_목록() {
        List<Integer> positions = Arrays.asList(1, 2, 3, 5, 1);
        assertThat(GameResult.maxPosition(positions))
                .isEqualTo(5);
    }

    @Test
    public void test_우승_없음() {
        List<RacingCar> cars = Arrays.asList(new NamedRacingCar("pobi"));
        GameResult gameResult = new GameResult(cars, 1);

        assertThat(gameResult.getWinnerNames())
                .isEmpty();
    }

    @Test
    public void test_우승_1대() {
        // given
        String winnerName = "pobi";
        NamedRacingCar winner = new NamedRacingCar(winnerName);
        int winnerPosition = winner.move(RacingCar.THRESHOLD_POWER);

        List<RacingCar> cars = Arrays.asList(winner);

        // when
        GameResult gameResult = new GameResult(cars, winnerPosition);

        // then
        assertThat(gameResult.getWinnerNames())
            .isEqualTo(winnerName);
    }

    @Test
    public void test_우승_2대() {
        // given
        List<String> winnerNames = Arrays.asList("pobi", " crong");
        List<RacingCar> winners = winnerNames.stream()
                .map(NamedRacingCar::new)
                .collect(Collectors.toList());

        int winnerPosition = GameResult.maxPosition(winners.stream()
                .map(car -> car.move(RacingCar.THRESHOLD_POWER))
                .collect(Collectors.toList()));
        // when
        GameResult gameResult = new GameResult(winners, winnerPosition);

        // then
        assertThat(gameResult.getWinnerNames())
                .isEqualTo(winnerNames.stream()
                        .collect(Collectors.joining(", ")));
    }
}