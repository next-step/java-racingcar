package racing;

import racing.model.Car;
import racing.model.Cars;
import racing.model.Racing;
import racing.util.RandomUtil;
import racing.view.RacingView;

public class RacingGame {

    private int gameCount = 0;

    public RacingGame(int gameCount) {
        this.gameCount = gameCount;
    }

    public void gameStart(Racing racing) {
        int count = 1;
        while (count < gameCount) {
            game(racing);
            count++;
            RacingView.printCarMove(racing);
        }
        RacingView.printCarMove(racing);
        RacingView.printWinner(racing.winner());
    }

    void game(Racing racing) {
        Cars cars = racing.participants();
        cars.carList()
                .forEach(car -> car.run(RandomUtil.randomValue()));
    }

}
