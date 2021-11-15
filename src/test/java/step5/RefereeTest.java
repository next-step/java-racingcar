package step5;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import step4.Car;
import step4.CarName;
import step4.RandomMoveStrategy;
import step4.Referee;

public class RefereeTest {

    private List<step4.Car> testCars;

    @BeforeEach
    void init() {
        testCars = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            testCars.add(new step4.Car("test" + i, new RandomMoveStrategy()));
        }
        while (testCars.get(0).getPosition() == 0) {
            testCars.get(0).move();
        }
    }

    @Test
    void getWinners() {
        List<Car> winners = Referee.getWinners(testCars);
        assertAll(
            () -> assertEquals(1, winners.size()),
            () -> assertThat(winners.get(0).getCarName()).isEqualTo(new CarName("test0")),
            () -> assertThat(winners.get(0).getPosition()).isEqualTo(1)
        );
    }

}
