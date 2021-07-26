package racing.domain.game.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.domain.car.entity.BasicCar;
import racing.domain.car.entity.Car;
import racing.domain.car.vo.Location;
import racing.domain.car.vo.Name;
import racing.domain.game.vo.Turn;

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

    @CsvSource({
            "테스트카1|테스트카2|테스트카3|테스트카4,*"
    })
    @DisplayName("asString 테스트")
    @ParameterizedTest
    public void asStringTest(String carNames, String dividedString) {
        Turn turn = new Turn();

        List<Car> cars = Arrays.stream(carNames.split("\\|"))
                .map(Name::new)
                .map(BasicCar::new)
                .collect(Collectors.toList());
        for (Car iCar : cars)
            turn.register(iCar, Location.empty());

        String testString = turn.asString((iCar, iLocation) ->
                String.format("%s %s", iCar, iLocation), dividedString);

        assertThat(testString).isNotEmpty();
    }
}