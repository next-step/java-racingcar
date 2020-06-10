package autoracing.view;

import autoracing.domain.Car;
import autoracing.domain.Location;
import autoracing.domain.RacingGame;
import autoracing.domain.RacingRule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static autoracing.domain.CarTest.makeCarsWithHistory;
import static autoracing.domain.CarTest.merge;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

public class WinnersRendererTest {
    @Test
    public void shouldConstructorArgumentsNotBeNull() {
        assertThatNullPointerException().isThrownBy(() -> {
            new WinnersRenderer(null, ", ");
        }).withMessage("phrase format must be not null.");
        assertThatNullPointerException().isThrownBy(() -> {
            new WinnersRenderer("%s", null);
        }).withMessage("delimiter must be not null.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "%s, %s"})
    public void shouldPhraseFormatHasOnlyOneStringFormatSpecifier() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new WinnersRenderer("", ",");
        }).withMessage("the phrase format includes '%s' only once.");
    }

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
        WinnersRenderer renderer = new WinnersRenderer("Winners are %s!!", ",");

        assertThat(renderer.render(game.getWinners())).isEqualTo("Winners are Ford,Renault!!");
    }
}
