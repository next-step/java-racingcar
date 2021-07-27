package racing;

import racing.model.Car;
import racing.model.Cars;
import racing.model.Racing;
import racing.util.RandomUtil;
import racing.view.RacingView;

public class RacingGame {

    private static final int MINIMUM_CONDITION = 4;
    private static final int MAXIMUM_CONDITION = 9;

    public void gameStart(String carNames, int gameCount) {
        int count = 1;
        Racing racing = new Racing();
        racing.prepareRacing(carNames, gameCount);

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
                .forEach(car -> run(car, RandomUtil.randomValue()));
        return racing.endGame(count);
    }

    public boolean run(Car car, int move) {
        if(moveCondition(move)) {
            car.go();
            return true;
        }
        return false;
    }

    public Boolean moveCondition(int randomValue) {
        if(randomValue > MAXIMUM_CONDITION) {
            throw new IllegalStateException();
        }
        if(randomValue >= MINIMUM_CONDITION && randomValue <= MAXIMUM_CONDITION) {
            return true;
        }
        return false;
    }
}
