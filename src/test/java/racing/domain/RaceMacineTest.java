package racing.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceMacineTest {
    @Test
    void testRaceMachineAccelerate(){
        RaceMachine ferrari = new RaceMachine(1);
        do {
            ferrari.accelerate();
        } while (ferrari.getLap() < 1);
        assertThat(ferrari.getHorsePower()).isGreaterThanOrEqualTo(4);
    }
}

