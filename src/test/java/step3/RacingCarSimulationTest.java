package step3;

import org.junit.jupiter.api.Test;

class RacingCarSimulationTest {

    @Test
    void start() {
        final Main.NextStepRacingCarSimulation simulation = new Main.NextStepRacingCarSimulation(new Main.InputView());
        simulation.start();
    }

}