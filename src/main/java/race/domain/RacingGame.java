package race.domain;

import race.util.RandomUtil;
import race.view.ResultView;

import java.util.List;

public class RacingGame {

    public List<Car> race(List<Car> carList, int tryCount) {
        ResultView resultView = new ResultView();
        resultView.printResult();

        for (int i = 0; i < tryCount; i++) {
            exploreCarList(carList);
            resultView.showResult(carList);
        }

        return carList;
    }

    private void exploreCarList(List<Car> carList) {
        RandomUtil randomUtil = new RandomUtil();

        for (int i = 0; i < carList.size(); i++) {
            int random = randomUtil.randomNum();
            carList.get(i).makeForward(random);
        }
    }
}
