package RacingCar;

import RacingCar.Model.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class RacingTest {
    @Test
    @DisplayName("한 라운드 테스트")
    void nameValidateTest() {
        Racing racing = new Racing(3);
        List<Car> list = new ArrayList<>();
        FixNumber fixNumber = new FixNumber();

        list.add(new Car("tom", 1));

        racing.round(fixNumber, list);

        assertThat(list.get(0).getPosition()).isEqualTo(2);
    }

    @Test
    @DisplayName("우승자 테스트")
    void winnerTest() {
        Winner winner = new Winner();
        FixNumber randomNumber = new FixNumber();
        List<Car> list = new ArrayList<>();

        list.add(new Car("tom", 1));
        list.add(new Car("jason", 2));
        list.add(new Car("jenny", 3));

        List<Car> result = winner.winner(list);

        assertThat(result.get(0).getName()).isEqualTo("jenny");
    }
}
