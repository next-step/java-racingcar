package racing;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private List<Car> cars;
    private final int turns;

    private RacingGame(int countOfCar, int turn) {

        this.turns = turn;
        List<Car> list = new ArrayList<>();
        for (int i = 0; i < countOfCar; i++) {
            list.add(new Car(0));
        }
        this.cars = list;
    }

    static RacingGame initGame() {
        int countOfCar = InputView.InputCountOfUnit();
        int turn = InputView.InputCountOfTurn();
        return new RacingGame(countOfCar, turn);
    }

    public void playGame() {
        
        for (int i = 0; i < this.turns; i++) {
            onceTurn();
        }
        ResultView.printCarsLocation(this.cars);
    }

    private void onceTurn() {
        for (int i = 0; i < this.cars.size(); i++) {
            Car movedCar = this.cars.get(i).move();
            this.cars.set(i, movedCar);
        }
    }
}
