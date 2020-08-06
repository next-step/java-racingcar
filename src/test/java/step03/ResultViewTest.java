package step03;

import org.junit.jupiter.api.Test;
import step03.calculatescore.CalculatorRandomScore;
import step03.car.Car;
import step03.car.CarCenter;
import step03.game.CarRacingGame;
import step03.util.Util;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Project : java-racingcar
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 12:15 오전
 */
class ResultViewTest {

    @Test
    public void ResultViewTest() {
        int moveCount = 3;

        CarCenter carCenter = new CarCenter();
        List<Car> cars = carCenter.makingCar(3);

        CarRacingGame carRacingGame = new CarRacingGame();
        carRacingGame.racing(cars, new CalculatorRandomScore());

        List<Car> carRacingGameCars = carRacingGame.getCars();
        assertThat(carRacingGameCars.size()).isEqualTo(3);

        Car car = carRacingGameCars.get(0);
        for (int i = 0; i < car.getMoveCount(); i++) {
            System.out.println(Util.moveStirng);
        }
    }
}