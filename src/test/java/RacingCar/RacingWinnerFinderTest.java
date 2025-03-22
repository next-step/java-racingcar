package RacingCar;

import NumberGenerator.TestNumberGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RacingWinnerFinderTest {
    private static final int MOVE_CONDITION = 4;

    @Test
    void winnersAreEqualToExpected() {
        String[] expectedWinners = new String[]{"car1", "car3"};
        RacingCar[] cars = new RacingCar[]{
                new RacingCar(MOVE_CONDITION, new TestNumberGenerator(MOVE_CONDITION), "car1"),
                new RacingCar(MOVE_CONDITION, new TestNumberGenerator(MOVE_CONDITION - 1), "car2"),
                new RacingCar(MOVE_CONDITION, new TestNumberGenerator(MOVE_CONDITION), "car3"),
        };

        for (RacingCar car : cars) {
            car.move();
        }

        RacingWinnerFinder finder = new RacingWinnerFinder(cars);
        finder.findWinners(1);
        RacingCar[] winners = finder.winners();
        for (int i = 0; i < winners.length; i++)
            assertEquals(winners[i].name(), expectedWinners[i]);
    }
}
