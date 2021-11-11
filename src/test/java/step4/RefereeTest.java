package step4;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RefereeTest {

    private Car[] testCars;

    @BeforeEach
    void init() {
        testCars = new Car[2];
        for (int i = 0; i < testCars.length; i++) {
            testCars[i] = new Car("test" + i, new RandomMoveStrategy());
        }
        while (testCars[0].getPosition() == 0) {
            testCars[0].move();
        }
    }

    @Test
    void getWinners() {
        Car[] winners = Referee.getWinners(testCars);
        assertAll(
            () -> assertEquals(1, winners.length),
            () -> assertThat(winners[0].getName()).isEqualTo("test0"),
            () -> assertThat(winners[0].getPosition()).isEqualTo(1)
        );
    }

}
