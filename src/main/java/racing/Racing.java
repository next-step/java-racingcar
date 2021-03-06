package racing;

import java.util.List;

public class Racing {

    private final List<Car> carList;
    private final ResultView resultView;
    private final int moves;

    public Racing(List<Car> carList, ResultView resultView, int moves) {
        this.carList = carList;
        this.resultView = resultView;
        this.moves = moves;
    }

    public void start() {
        for (int i = 0; i < moves; i++) {
            carList.forEach(Car::move);
            resultView.printRacingState(this);
        }
    }

    public List<Car> getCarList() {
        return carList;
    }
}
