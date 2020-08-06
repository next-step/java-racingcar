import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class RefereeTest {

    @Test
    @DisplayName("최종 우승이 누구인지 가린다.")
    void test() {
        List<Car> finishedCars = new ArrayList<>();
        finishedCars.add(new Car(null, "hi"));
        finishedCars.add(new Car(null, "hi2"));
        finishedCars.add(new Car(null, "hi3"));

        Referee referee = new Referee(finishedCars);
        String winnersCarNames = referee.getWinnersCarNames();

        String expected = finishedCars.stream().map(Car::getName).collect(Collectors.joining(","));

        assertThat(winnersCarNames).isEqualTo(expected);
    }


}