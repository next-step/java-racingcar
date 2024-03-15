package race.domain;

import race.util.RandomUtil;
import race.view.ResultView;

import java.util.List;

public class RacingGame {

    public void race(List<Car> carList, int tryCount) {
        ResultView resultView = new ResultView();
        resultView.printResult();

        for (int i = 0; i < tryCount; i++) {
            exploreCarList(carList);
            resultView.showResult(carList);
        }
    }

    private void exploreCarList(List<Car> carList) {
        RandomUtil randomUtil = new RandomUtil();

        for (int i = 0; i < carList.size(); i++) {
            int random = randomUtil.randomNum();
            makeForward(carList.get(i), random);
        }
    }

    private void makeForward(Car car, int number) {
        if (car.canForward(number))
            car.move();
    }
}
