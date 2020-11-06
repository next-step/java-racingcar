package racing.controller;

import org.junit.jupiter.api.Test;
import racing.domain.GrandPrix;
import racing.view.to.RacingInputTO;

import static org.assertj.core.api.Assertions.assertThat;

public class GrandPrixControllerTest {
    private final GrandPrixController grandPrixController = new GrandPrixController();

    @Test
    void testCreate() {
        GrandPrix grandPrix = grandPrixController.create(new RacingInputTO(3, 5));
        assertThat(grandPrix.getId()).isNotNull();
        assertThat(grandPrix.getLineUp()).isNotNull();
        assertThat(grandPrix.getLineUp().getMachinesInLap(1)).size().isEqualTo(3);
    }

    @Test
    void testStartRace() {
        GrandPrix grandPrix = grandPrixController.create(new RacingInputTO(3, 5));
        grandPrixController.startRace(grandPrix);
        assertThat(grandPrix.getCurrentRound()).isEqualTo(grandPrix.getMaxRounds());
    }
}

