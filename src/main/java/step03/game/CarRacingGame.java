package step03.game;

import step03.calculatescore.ScoreCalculate;
import step03.car.Car;
import step03.view.ResultView;

import java.util.List;

/**
 * Project : java-racingcar
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 11:02 오후
 */
public class CarRacingGame {

    private List<Car> cars;

    public void racing(List<Car> cars, ScoreCalculate scoreCalculate) {

        for (int i = 0; i < cars.size(); i++) {

            int randomNum = scoreCalculate.calculateScore();
            cars.get(i).AdvanceOneSpace(randomNum);
            this.cars = cars;

            drawScoreBard();
        }
    }

    public void drawScoreBard() {
        ResultView resultView = new ResultView();

        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            resultView.draw(car);
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
