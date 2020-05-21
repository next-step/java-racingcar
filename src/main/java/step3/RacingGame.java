package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private ArrayList<Car> carpositions = new ArrayList<>();
    private OutputView outputView = new OutputView();
    public RacingGame(int carCount) {
        for (int i = 0; i < carCount; i++) {
            this.carpositions.add(new Car());
        }
    }
    public void playGame() {
        for (Car car:carpositions) {
            car.canGo();
        }
        outputView.resultPrint(carpositions);
    }
}
