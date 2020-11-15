package racingcar.domain;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.car.Name;
import racingcar.domain.car.Position;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @Test
    @DisplayName("주어진 이름에 맞는 자동차들을 반환한다")
    public void should_return_cars_by_names_of_cars() {
        //Given
        RacingGame racingGame = new RacingGame();
        List<String> carNames = Lists.newArrayList("damas", "bmw", "benz");

        //When
        Cars cars = racingGame.createCars(carNames);

        //Then
        assertThat(cars.getCarNames()).containsAll(carNames);
    }

    @Test
    @DisplayName("주어진 이름에 없는 자동차는 반환하지 않는다")
    public void should_not_return_cars_not_in_car_names() {
        //Given
        RacingGame racingGame = new RacingGame();
        List<String> carNames = Lists.newArrayList("damas", "bmw", "benz");

        //When
        Cars cars = racingGame.createCars(carNames);

        //Then
        assertThat(cars.getCarNames()).doesNotContain("k5").isNotEmpty();
    }

    @Test
    @DisplayName("자동차들 중 우승자(들)를 반환한다")
    void should_return_winners() {
        //Given
        RacingGame racingGame = new RacingGame();
        Cars cars = getRacingGameResult();

        //When
        Cars winners = racingGame.getWinners(cars);

        //Then
        assertThat(winners.getCarNames())
                .containsAll(Lists.newArrayList("damas", "bmw"));

    }

    @Test
    @DisplayName("자동차들 중 우승자가 아니면 반환하지 않는다")
    void should_not_return_winners() {
        //Given
        RacingGame racingGame = new RacingGame();
        Cars cars = getRacingGameResult();

        //When
        Cars winners = racingGame.getWinners(cars);

        //Then
        assertThat(winners.getCarNames()).doesNotContain("benz").isNotEmpty();

    }

    private Cars getRacingGameResult() {
        List<Car> carList = new ArrayList<>();

        Name damas = new Name("damas");
        Name bmw = new Name("bmw");
        Name benz = new Name("benz");

        Position winner = new Position(3);
        Position loser = new Position(0);

        carList.add(new Car(damas, winner));
        carList.add(new Car(bmw, winner));
        carList.add(new Car(benz, loser));

        return new Cars(carList);
    }

}