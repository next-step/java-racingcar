package step4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.game.domain.car.Car;
import step3.game.domain.car.CarName;
import step3.game.domain.car.Players;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PlayersTest {

    private Players players;

    @BeforeEach
    void setUp() {
        Set<Car> cars = new HashSet<>();
        cars.add(new Car(new CarName("테스트1"), 3));
        cars.add(new Car(new CarName("테스트2"), 4));
        cars.add(new Car(new CarName("테스트3"), 5));

        players = new Players(cars);
    }

    @Test
    @DisplayName("우승자를 선정할 수 있다.")
    void finalResultTest() {
        List<String> winners = players.finalResult();

        assertThat(winners).isEqualTo(List.of("테스트3"));
    }
}
