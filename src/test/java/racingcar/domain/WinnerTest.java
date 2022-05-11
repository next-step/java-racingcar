package racingcar.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.car.Participant;
import racingcar.domain.car.Position;
import racingcar.domain.racinggame.Winners;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerTest {

    private static final List<Car> carList = new ArrayList<>();

    @BeforeAll
    static void beforeAll() {
        carList.add(new Car(new Participant("hong"), new Position(3)));
        carList.add(new Car(new Participant("bok"), new Position(4)));
        carList.add(new Car(new Participant("zi"), new Position(5)));
        carList.add(new Car(new Participant("kim"), new Position(1)));
    }

    @Test
    void findWinnersTest() {

        Cars cars = new Cars(carList);

        Winners winnersTest = new Winners(cars);

        List<Car> winnerList = winnersTest.getWinners();

        assertThat(winnerList).contains(new Car(new Participant("zi"), new Position(5)));
    }
}
