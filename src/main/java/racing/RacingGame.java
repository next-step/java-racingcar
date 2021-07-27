package racing;

import racing.model.Car;
import racing.model.Cars;
import racing.model.Racing;
import racing.util.RandomUtil;
import racing.view.RacingView;

public class RacingGame {

    private static final int minimumCondition = 4;
    private static final int maximumCondition = 9;

    public void gameStart(int carSize, int gameCount) {
        int count = 1;
        Racing racing = new racing.model.Racing();
        racing.prepareRacing(carSize, gameCount);

        RacingView racingView = new RacingView();
        while (!game(racing, count)) {
            count++;
            racingView.printCarMove(racing);
        }
        racingView.printCarMove(racing);
    }

    public Boolean game(Racing racing, int count) {
        Cars cars = racing.participants();
        cars.carList()
                .forEach(car -> carMove(car, RandomUtil.randomValue()));
        return racing.endGame(count);
    }

    public boolean carMove(Car car, int move) {
        if(moveCondition(move)) {
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
