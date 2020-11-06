package racing.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racing.domain.GrandPrix;
import racing.view.to.RacingInputTO;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class GrandPrixControllerTest {
    private final GrandPrixController grandPrixController = new GrandPrixController();

    RacingInputTO racingInputTO;

    @BeforeEach
    void makeTestGrandPrix() {
        racingInputTO = new RacingInputTO(Arrays.asList("Lewis Hamilton", "Valtteri Bottas", "Max Verstappen", "Daniel Ricciardo"), 5);
    }

    @Test
    void testCreate() {
        GrandPrix grandPrix = grandPrixController.create(racingInputTO);
        assertThat(grandPrix).isNotNull();
        assertThat(grandPrix.getLineUp()).isNotNull();
        assertThat(grandPrix.getLineUp().getMachinesInLap(1)).size().isEqualTo(3);
    }

    @Test
    void testStartRace() {
        GrandPrix grandPrix = grandPrixController.create(racingInputTO);
        grandPrixController.startRace(grandPrix);
        assertThat(grandPrix.getCurrentRound()).isEqualTo(grandPrix.getMaxRounds());
    }
}

