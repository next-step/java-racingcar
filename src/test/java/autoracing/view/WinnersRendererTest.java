package autoracing.view;

import autoracing.domain.Car;
import autoracing.domain.Location;
import autoracing.domain.RacingGame;
import autoracing.domain.RacingRule;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static autoracing.domain.CarTest.makeCarsWithHistory;
import static autoracing.domain.CarTest.merge;
import static org.assertj.core.api.Assertions.assertThat;

public class WinnersRendererTest {
    @Test
    public void renderTest() {
        RacingRule mockRule = () -> false;
        List<Location> winnersHistory = new ArrayList<>(Arrays.asList(
                Location.STARTING_LINE,
                Location.STARTING_LINE.move(1)
        ));

        List<Location> losersHistory = new ArrayList<>(Arrays.asList(
                Location.STARTING_LINE,
                Location.STARTING_LINE
        ));

        List<Car> winners = makeCarsWithHistory(
                mockRule,
                winnersHistory,
                "Ford",
                "Renault");
        List<Car> losers = makeCarsWithHistory(mockRule,
                losersHistory,
                "Mercedes",
                "Ferrari",
                "Lamborghini",
                "McLaren");

        RacingGame game = new RacingGame(1, merge(winners, losers));
        WinnersRenderer renderer = new WinnersRenderer(game.getWinners(), ",");

        assertThat(renderer.render()).isEqualTo("Ford,Renault");
    }
}
