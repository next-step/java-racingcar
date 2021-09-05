package stage4;

import org.junit.jupiter.api.Test;
import stage4.domain.*;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    @Test
    void tryRacingTest() {
        final String[] carNames = {"a", "b", "c"};
        final Cars cars = new Cars(carNames);
        final List<Car> actual = cars.tryRacing(new RandomMovableStrategy() {
            @Override
            public int getForwardPosition() {
                return 4;
            }
        });

        final List<Car> expected = Arrays.asList(new Car(new CarName("a"), new Position(1)),
                new Car(new CarName("b"), new Position(1)),
                new Car(new CarName("c"), new Position(1)));

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void findLastRacingResults() {
        final String[] carNames = {"a", "b", "c"};
        final Cars cars = new Cars(carNames);
        for (int i = 0; i < 2; i++) {
            cars.tryRacing(new RandomMovableStrategy() {
                @Override
                public int getForwardPosition() {
                    return 4;
                }
            });
        }
        final Cars actual = cars.findLastRacingResults(carNames.length);
        final Cars expected = new Cars(Arrays.asList(
                new Car(new CarName("a"), new Position(2)),
                new Car(new CarName("b"), new Position(2)),
                new Car(new CarName("c"), new Position(2))));

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void findWinnerTest() {
        final Position maxPosition = new Position(3);
        final Car winner = new Car(new CarName("win"), maxPosition);

        final Cars cars = new Cars(Arrays.asList(
                new Car(new CarName("lose1"), new Position(1)),
                winner,
                new Car(new CarName("lose2"), new Position(0))));

        final Cars actual = cars.findWinners();
        final Cars expected = new Cars(Arrays.asList(winner));

        assertThat(actual).isEqualTo(expected);
    }
}
