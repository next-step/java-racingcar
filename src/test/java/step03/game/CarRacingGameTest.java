package step03.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import step03.calculatescore.CalculatorRandomScore;
import step03.calculatescore.ScoreCalculate;
import step03.car.Car;
import step03.car.CarCenter;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Project : java-racingcar
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 11:06 오후
 */
class CarRacingGameTest {
    List<Car> cars;
    CarRacingGame carRacingGame;

    @BeforeEach
    public void init() {
        carRacingGame = new CarRacingGame();
        cars = new ArrayList<>();
        cars.add(new Car("junwoo", 2));
        cars.add(new Car("sungah", 4));
    }

    @Test
    public void raceTest() {
        CarRacingGame carRacingGame = new CarRacingGame();
        carRacingGame.gameStart(cars, new CalculatorRandomScore());

        if (carRacingGame.getRandomNum() >= 4) {
            assertThat(cars.get(0).getMoveCount()).isGreaterThan(2);
            assertThat(cars.get(1).getMoveCount()).isGreaterThan(4);
        }
    }

}