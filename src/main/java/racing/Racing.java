package racing;

import racing.model.CarModel;
import racing.model.CarsModel;
import racing.model.RacingModel;
import racing.util.RandomUtil;
import racing.view.RacingView;

public class Racing {

    private static final int minimumCondition = 4;
    private static final int maximumCondition = 9;

    public void gameStart(int carSize, int gameCount) {
        int count = 1;
        RacingModel racingModel = new RacingModel();
        racingModel.prepareRacing(carSize, gameCount);

        RacingView racingView = new RacingView();
        while (!game(racingModel, count)) {
            count++;
            racingView.printCarMove(racingModel);
        }
        racingView.printCarMove(racingModel);
    }

    public Boolean game(RacingModel racingModel, int count) {
        CarsModel cars = racingModel.participants();
        cars.carList()
                .forEach(car -> carMove(car, RandomUtil.randomValue()));
        return racingModel.endGame(count);
    }

    public boolean carMove(CarModel car, int randomValue) {
        if(moveCondition(randomValue)) {
            car.go();
            return true;
        }
        return false;
    }

    public Boolean moveCondition(int randomValue) {
        if(randomValue > maximumCondition) {
            throw new IllegalStateException();
        }
        if(randomValue >= minimumCondition && randomValue <= maximumCondition) {
            return true;
        }
        return false;
    }
}
