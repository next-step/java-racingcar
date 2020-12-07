package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarRacingTest {

    private CarRacing carRacing;
    private Display display;
//    private InputUtil inputUtil;
    private ParticipateCars participateCars;
    @BeforeEach
    void setup(){
        display = new Display();
        String [] carNames = {"Morris", "Daniel", "Choi"};
        participateCars = new ParticipateCars(carNames);
        carRacing = new CarRacing( participateCars, display);
    }

    @Test
    void winnerTest() {
        carRacing.startRacing(3);
        String[] winner = carRacing.winner().split(",");
        assertThat(winner.length).isGreaterThan(0);
    }
}