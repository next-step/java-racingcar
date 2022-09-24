package racing_car.step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RefereeTest {
    @Test
    @DisplayName("우승자 한 명 구하기")
    void findWinner() {
        Car jun = new Car(new CarName("jun"), new Position(5));
        Car pobi = new Car(new CarName("pobi"), new Position(4));
        Car young = new Car(new CarName("young"), new Position(3));
        Cars cars = new Cars(Arrays.asList(jun, pobi, young));
        Referee referee = new Referee(cars);
        
        List<String> winnersName = referee.getWinnersNameList();
        assertThat(winnersName).isEqualTo(List.of("jun"));
    }
}
