import CarRacing.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TestCarRacingCompetition {

    Competition competition;

    private final MovingStrategy movingStrategy = new MovingStrategyStaticInt();

    @BeforeEach
    public void setUp() {
        competition = new Competition();
    }

    @Test
    @DisplayName("winner 여러 명 확인")
    public void winner_multi_cars() {
        String[] expected = {"pobi", "crong", "honux"};

        String[] entries = {"pobi", "jk", "hyune","crong", "honux", "chunk"};
        int[] positions = {5, 2, 4, 5, 5, 1};

        List<Car> cars = new ArrayList<>();
        for (int ix =0; ix< entries.length; ix++) {
            Car car = new Car(entries[ix]);
            car.move(positions[ix]);
            cars.add(car);
        }

        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            competition.addIfWinner(winners, car, 6);
        }

        String[] actual = new String[winners.size()];
        for(Car car : winners) {
            actual[winners.indexOf(car)] = car.name();
        }

        assertThat(actual).isEqualTo(expected);
    }



}
