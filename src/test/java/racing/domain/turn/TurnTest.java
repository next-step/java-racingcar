package racing.domain.turn;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.car.BasicCar;
import racing.domain.car.Car;
import racing.domain.Location;
import racing.domain.Name;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class TurnTest {
    @DisplayName("findWinners 테스트")
    @Test
    public void findWinnersTest() {
        Turn turn = new Turn();

        turn.register(new BasicCar(new Name("패배자")), Location.empty());
        turn.register(new BasicCar(new Name("우승자")), Location.oneBlock());
        turn.register(new BasicCar(new Name("우승자2")), Location.oneBlock());

        List<String> winnerNames = turn.findWinnerNames();
        assertThat(winnerNames)
                .containsOnly("우승자", "우승자2");
    }

    @DisplayName("register & checkLocation 테스트")
    @Test
    public void registerTest() {
        Turn turn = new Turn();
        Car car = new BasicCar(new Name("테스트카"));
        turn.register(car, Location.empty());

        assertThat(turn.checkLocation(car, Location.empty()))
                .isTrue();
    }
}