package racing.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racing.domain.GrandPrix;
import racing.resolver.SimpleAccelerateResolver;
import racing.service.GrandPrixService;
import racing.service.LineUpService;
import racing.service.RaceMachineService;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;

class GrandPrixControllerTest {
    private static final GrandPrixService grandPrixService = new GrandPrixService();
    private static final LineUpService lineUpService = new LineUpService(new RaceMachineService(), new SimpleAccelerateResolver(true));
    private final GrandPrixController grandPrixController = new GrandPrixController(grandPrixService, lineUpService);

    private static final String DRIVERS = "Lewis,Botta,Max";
    private static final int MAX_ROUND = 5;

    @BeforeEach
    void makeTestInput() {
        String sample = DRIVERS + "\n" + MAX_ROUND;

        ByteArrayInputStream in = new ByteArrayInputStream(sample.getBytes());
        System.setIn(in);
    }

    @Test
    void testCreate() {
        GrandPrix grandPrix = grandPrixController.create();
        assertThat(grandPrix).isNotNull();
        assertThat(grandPrix.getLineUp()).isNotNull();
    }

    @Test
    void testStartRace() {
        GrandPrix grandPrix = grandPrixController.create();
        grandPrixController.startRace(grandPrix);
        assertThat(grandPrix.getCurrentRound()).isEqualTo(grandPrix.getMaxRounds());
    }
}

