package carRacing.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {


    @Test
    @DisplayName("빈 자동차 리스트로 생성시 예외처리")
    void RacingGameTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new RacingGame(new RacingCarGroup(new ArrayList<>()), new MockGamePoint(3));
        });
    }



    @Test
    @DisplayName("자동차 경주 자동차 이동")
    void race() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("ferrari"));
        cars.add(new Car("bmw"));
        cars.add(new Car("audi"));
        MockGamePoint mockGamePoint = new MockGamePoint(5); // 항상 전진
        RacingGame racingGame = new RacingGame(new RacingCarGroup(cars), mockGamePoint);


        racingGame.race();
        RacingCarGroup race = racingGame.race();
        List<Car> racingCars = race.getRacingCars();
        for (Car racingCar : racingCars) {
            assertThat(racingCar.getPosition()).isEqualTo(2);
        }
    }

    @Test
    @DisplayName("자동차 경주 자동차 이동할 수 없음")
    void cannotMove() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("ferrari"));
        cars.add(new Car("bmw"));
        cars.add(new Car("audi"));
        MockGamePoint mockGamePoint = new MockGamePoint(3); // 항상 Stop
        RacingGame racingGame = new RacingGame(new RacingCarGroup(cars), mockGamePoint);


        racingGame.race();
        RacingCarGroup race = racingGame.race();
        List<Car> racingCars = race.getRacingCars();
        for (Car racingCar : racingCars) {
            assertThat(racingCar.getPosition()).isEqualTo(0);
        }
    }

    @Test
    @DisplayName("우승자 판별")
    void gameResult() {

        List<Car> cars = new ArrayList<>();
        cars.add(new Car("ferrari"));
        cars.add(new Car("bmw"));
        cars.add(new Car("audi"));
        MockGamePoint mockGamePoint = new MockGamePoint(5); // 항상 전진
        RacingGame racingGame = new RacingGame(new RacingCarGroup(cars), mockGamePoint);

        racingGame.race();
        RacingCarGroup winners = racingGame.gameResult();

        Car ferrari = new Car("ferrari");
        Car bmw = new Car("bmw");
        Car audi = new Car("audi");
        assertThat(winners.getRacingCars()).containsExactly(ferrari, bmw, audi);



    }
}