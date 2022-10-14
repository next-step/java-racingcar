package RacingCar;

import RacingCar.domain.Car;
import RacingCar.domain.MovingStrategy;
import RacingCar.domain.Winner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WinnerTest {

    @Test
    @DisplayName("우승자 테스트")
    void winnerTest() {
        MovingStrategy randomNumber = new MovingStrategy() {
            @Override
            public boolean moveable() {
                return true;
            }
        };
        List<Car> list = new ArrayList<>();
        list.add(new Car("tom", 1));
        list.add(new Car("jason", 2));
        list.add(new Car("jenny", 3));

        Winner winner = new Winner(list);

        List<Car> result = winner.findWinners();

        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0).getName()).isEqualTo("jenny");
    }
}
