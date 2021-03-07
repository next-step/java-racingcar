package racing;

import racing.car.Car;
import racing.view.ResultView;

import java.util.List;

public class Racing {

    private final List<Car> carList;
    private final ResultView resultView = new ResultView("-");
    private final int moves;

    public Racing(List<Car> carList, int moves) {
        this.carList = carList;
        this.moves = moves;
    }

    public void run() {
        for (int i = 0; i < moves; i++) {
            carList.forEach(Car::move);
            resultView.printRacingState(carList);
        }
    }

}
