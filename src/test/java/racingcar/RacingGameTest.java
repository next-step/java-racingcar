package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;

class RacingGameTest {

    @Test
    @DisplayName("레이싱 게임의 우승자를 찾는다.")
    void findRacingWinnerTest() {
        Car avante = new Car("아반떼");
        Car sonata = new Car("소나타");

        avante.tryMove(5);
        sonata.tryMove(2);

        List<Car> cars = List.of(avante, sonata);
        Cars racingCars = new Cars(cars);
    }

}