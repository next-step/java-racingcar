package racing.car;

import racing.game.RacingCalculator;
import racing.view.ResultView;

import java.util.List;

public class Cars {

    private final List<Car> items;

    public Cars(List<Car> items) {
        this.items = items;
    }

    public int carSize() {
        return items.size();
    }

    public void carGoAndStop(RacingCalculator racingCalculator) {
        for (Car item : items) {
            item.isGo(racingCalculator.getRandomNumber());
            ResultView.resultGoAndStop(item);
        }
        ResultView.endCycle(); //사이클 끝났다 출력
    }


}
