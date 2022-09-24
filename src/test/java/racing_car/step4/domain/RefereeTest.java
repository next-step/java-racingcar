package racing_car.step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RefereeTest {
    @Test
    @DisplayName("우승자 구하기")
    void findWinner() {
        Cars cars = new Cars(Arrays.asList(new Car(new CarName("jun"), new Position(5)), new Car(new CarName("pobi"), new Position(4)), new Car(new CarName("young"), new Position(3))));
        Referee referee = new Referee(cars);
        List<String> winnersName = referee.getWinnersNameList();
        assertThat(winnersName).isEqualTo(List.of("jun"));
    }
}
