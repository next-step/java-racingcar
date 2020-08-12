package step03.calculatescore;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import step03.car.Car;
import step03.car.CarCenter;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Project : java-racingcar
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 10:53 오후
 */
class WinnerCalculateTest {

    private List<Car> cars = new ArrayList<>();

    @BeforeEach
    public void init() {

        int tryNum = 5;
        String carTestName = "choi,jo,kim";
        String[] carName = carTestName.split(",");
        final CarCenter carCenter = new CarCenter();
        cars = carCenter.makingCar(carName);
        final ScoreCalculate scoreCalculate = new CalculatorRandomScore();

        int round = 5;
        while (round-- > 0) {
            for (int m = 0; m < cars.size(); m++) {
                cars.get(m).advanceOneSpace(scoreCalculate.calculateScore());
            }
        }
    }

    @Test
    public void winnerCalculateTest() {
        int winnerCount = Integer.MAX_VALUE;

        for (int i = 0; i < cars.size(); i++) {
            int moveCount = cars.get(i).getMoveCount();
            if (winnerCount > moveCount) {
                winnerCount = moveCount;
            }
        }
    }
}