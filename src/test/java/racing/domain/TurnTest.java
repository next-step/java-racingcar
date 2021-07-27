package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.car.BasicCar;
import racing.domain.car.Car;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


class TurnTest {
    @DisplayName("findWinners 테스트")
    @Test
    public void findWinnersTest() {
        Map<Car, Location> data = new HashMap<>();
        data.put(new BasicCar(new Name("패배자")), Location.empty());
        data.put(new BasicCar(new Name("우승자")), Location.oneBlock());
        data.put(new BasicCar(new Name("우승자2")), Location.oneBlock());

        Turn turn = new Turn(data);

        List<String> winnerNames = turn.findWinnerNames();
        assertThat(winnerNames)
                .containsOnly("우승자", "우승자2");
    }
}