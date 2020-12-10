package racing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racing.domain.CarRacing;
import racing.domain.ParticipateCars;

import static org.assertj.core.api.Assertions.assertThat;

class CarRacingTest {

    private CarRacing carRacing;
    private ParticipateCars participateCars;
    @BeforeEach
    void setup(){
        String [] carNames = {"Morris", "Daniel", "Choi"};
        participateCars = new ParticipateCars(carNames);
        carRacing = new CarRacing( participateCars);
    }

    @Test
    void winnerTest() {
        carRacing.startRacing();
        String[] winner = carRacing.presentWinner().split(",");
        assertThat(winner.length).isGreaterThan(0);
    }
}