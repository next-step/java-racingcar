package step03;

import org.junit.jupiter.api.Test;
import step03.calculatescore.CalculatorRandomScore;
import step03.calculatescore.ScoreCalculate;
import step03.car.Car;
import step03.car.CarCenter;

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

    @Test
    public void raceTest() {
        final int carNum = 3;
        int tryNum = 5;

        final CarCenter carCenter = new CarCenter();
        final List<Car> cars = carCenter.makingCar(carNum);
        final ScoreCalculate scoreCalculate = new CalculatorRandomScore();

        int i = 0;
        while (tryNum-- > 0) {
            i++;
        }
        assertThat(i).isEqualTo(5);

        for (int m = 0; m < cars.size(); m++) {
            cars.get(i).AdvanceOneSpace(scoreCalculate.calculateScore());
            System.out.println(cars.get(i).getMoveCount());
        }
    }

}