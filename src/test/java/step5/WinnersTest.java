package step5;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WinnersTest {

    private List<Car> testCars;

    @BeforeEach
    void init() {
        testCars = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            testCars.add(new Car("test" + i, new RandomMoveStrategy()));
        }
        while (testCars.get(0).getPosition().getPosition() == 0) {
            testCars.get(0).move();
        }
    }

    @Test
    void getWinners() {
        List<Car> winners = Winners.getWinners(testCars);
        assertAll(
            () -> assertEquals(1, winners.size()),
            () -> assertThat(winners.get(0).getCarName()).isEqualTo(new CarName("test0"))
//            () -> assertThat(winners.get(0).getPosition()).isEqualTo(new Position(1))
        );
    }

}
