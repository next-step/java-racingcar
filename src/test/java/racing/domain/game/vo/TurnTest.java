package racing.domain.game.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.domain.car.entity.BasicCar;
import racing.domain.car.entity.Car;
import racing.domain.car.vo.Location;
import racing.domain.car.vo.Name;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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