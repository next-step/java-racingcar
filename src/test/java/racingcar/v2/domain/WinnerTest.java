package racingcar.v2.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import racingcar.v1.domain.RacingRecord;
import racingcar.v2.domain.car.Car;
import racingcar.v2.domain.car.Participant;
import racingcar.v2.domain.car.Position;

import java.util.ArrayList;
import java.util.List;

public class WinnerTest {

    private static final List<Car> cars = new ArrayList<>();

    @BeforeAll
    static void beforeAll() {
        cars.add(new Car(new Participant("hong"), new Position(3)));
        cars.add(new Car(new Participant("bok"), new Position(4)));
        cars.add(new Car(new Participant("zi"), new Position(5)));
        cars.add(new Car(new Participant("kim"), new Position(1)));
    }

    @Test
    void findWinnersTest() {
        List<Car> winnerList = Winners.findWinner(cars);

        Assertions.assertThat(winnerList).contains(new Car(new Participant("zi"), new Position(5)));
    }
}
